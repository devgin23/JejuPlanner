var mapImage="";

// 새로고침 감지 및 Controller 정적 계획 리스트 초기화
if(performance.navigation.type == 1){
	location.href="/plan/write/clear";
}

//주소-좌표 변환 객체를 생성합니다
var markerCount = 0;

// 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
var placeOverlay = new kakao.maps.CustomOverlay({zIndex:1}), 
    contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다 
    markers = [], // 마커를 담을 배열입니다
    scheduleMarkers = [], // 내 일정에 관한 마커를 담을 배열
    currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다
 
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.375721, 126.545364), // 지도의 중심좌표
        level: 9 // 지도의 확대 레벨
    };  
// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 
// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(map); 
// 지도에 idle 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'idle', searchPlaces);
// 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다 
contentNode.className = 'placeinfo_wrap';
// 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
// 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다 
addEventHandle(contentNode, 'mousedown', kakao.maps.event.preventMap);
addEventHandle(contentNode, 'touchstart', kakao.maps.event.preventMap);
// 커스텀 오버레이 컨텐츠를 설정합니다
placeOverlay.setContent(contentNode);  
// 각 카테고리에 클릭 이벤트를 등록합니다
addCategoryClickEvent();
// 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
function addEventHandle(target, type, callback) {
    if (target.addEventListener) {
        target.addEventListener(type, callback);
    } else {
        target.attachEvent('on' + type, callback);
    }
}
// 카테고리 검색을 요청하는 함수입니다
function searchPlaces() {
    if (!currCategory) {
        return;
    }
    
    // 커스텀 오버레이를 숨깁니다 
    placeOverlay.setMap(null);
    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    ps.categorySearch(currCategory, placesSearchCB, {useMapBounds:true}); 
}
// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        displayPlaces(data);
    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요
    } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
        
    }
}
// 지도에 마커를 표출하는 함수입니다
function displayPlaces(places) {
    // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
    // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
    var order = document.getElementById(currCategory).getAttribute('data-order');
    
    for ( var i=0; i<places.length; i++ ) {
            // 마커를 생성하고 지도에 표시합니다
            var marker = addMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order);
            // 마커와 검색결과 항목을 클릭 했을 때
            // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
            (function(marker, place) {
                kakao.maps.event.addListener(marker, 'click', function() {
                    displayPlaceInfo(place);
                });
            })(marker, places[i]);
    }
}
// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, order) {
    var imageSrc = '/resources/images/spriteicon.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(46, (order*36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });
    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다
    return marker;
}
// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}
// 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
function displayPlaceInfo (place) {
	
	// API 호출 (관광지 사진)
	visitKoreaAPI(place.place_name);
	
    var content = '<div class="placeinfo">' +
                    '   <div id="btn" class="title" type="button" title="' + place.place_name + '">' + place.place_name + '</div>';
    	//이미지 삽입
    	content += '<img src ='+ mapImage + ' alt="사진이없습니다." style="width:300px; height:150px; object-fit:contain; border:3px solid black">'
    	 if (place.road_address_name) {
    	        content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
    	                    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
    	 	} else {
    	        content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
    	    }                
    			content += '    <span class="tel">' + place.phone + '</span>' + 
    	                '</div>' + 
    	                '<div class="after"></div>';
    	    contentNode.innerHTML = content;
    	    placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
    	    placeOverlay.setMap(map);  
    	    mapImage = "";
    	    
    	    	var frm = {
				    	place : place.place_name,
				    	addr : place.road_address_name,
				    	longitude : place.x,
				    	latitude : place.y
    	    	}
    	    	//도로명 주소 없을 경우 지번 주소 대입
    	    	if(frm.addr==""){
    	    		frm.addr = place.address_name;
    	    	}
    	    	
    	    $('#btn').on('click', function() {
    			$.ajax({
    				url : "/plan/fromMap",
    				type : "POST",
    				data : JSON.stringify(frm),
    				contentType : "application/json; charset=utf-8;",
    				dataType : "json",
    				success : function(data1) {
    					$('#placeInit'+idx).val(data1.place);
    					$('#addr'+idx).val(data1.addr);
    					$('#longitude' + idx).val(data1.longitude);
    					$('#latitude' + idx).val(data1.latitude);
    				},
    				error : function() {
    					alert("simpleWithObject err");
    				}
    			});
    		});
    }

// 각 카테고리에 클릭 이벤트를 등록합니다
function addCategoryClickEvent() {
    var category = document.getElementById('category'),
        children = category.children;
    for (var i=0; i<children.length; i++) {
        children[i].onclick = onClickCategory;
    }
}
// 카테고리를 클릭했을 때 호출되는 함수입니다
function onClickCategory() {
    var id = this.id,
        className = this.className;
    placeOverlay.setMap(null);
    if (className === 'on') {
        currCategory = '';
        changeCategoryClass();
        removeMarker();
    } else {
        currCategory = id;
        changeCategoryClass(this);
        searchPlaces();
    }
}
// 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
function changeCategoryClass(el) {
    var category = document.getElementById('category'),
        children = category.children,
        i;
    for ( i=0; i<children.length; i++ ) {
        children[i].className = '';
    }
    if (el) {
        el.className = 'on';
    } 
}

// 내 일정의 장소 마커를 등록하는 함수
function scheduleAddMarker(latitude, longitude) {
	
	markerCount++;
	
	var markerPosition  = new kakao.maps.LatLng(latitude, longitude);
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	
	//마커에 일정과의 매핑을 위한 속성 추가
	marker.markerNo = markerCount;
	
	//마커 배열에 담기
	scheduleMarkers.push(marker);
}

// 내 일정의 장소 마커를 지우는 함수
$(document).on("click", 'button[id^=deletePlan]', function scheduleRemoveMarker() {
	
	console.log("markerNo : " + $(this).siblings('p[id^=markerNo]').html());
	
	scheduleMarkers[$(this).siblings('p[id^=markerNo]').html() - 1].setMap(null);
});

//한국관광공사 API 세팅
  function visitKoreaAPI(place_name) {
	
	var serviceKey = "O04vU1%2FBaFzYfPxBOYalRBg4ol8tZGeSgRc1SDG6HnIBdhw0XE6GHIcpyCrLSFpb8x%2BRe3mVF8SWqz0nIFj7RA%3D%3D";
	var xhr = new XMLHttpRequest();
	var url = 'http://api.visitkorea.or.kr/openapi/service/rest/PhotoGalleryService/gallerySearchList'; //URL
	var queryParams = '?' + encodeURIComponent('ServiceKey') + '='+ serviceKey; //Service Key
	queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); //페이지번호
	queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('1'); //한 페이지 결과 수
	queryParams += '&' + encodeURIComponent('MobileOS') + '=' + encodeURIComponent('ETC'); //IOS(아이폰), AND(안드로이드), WIN(윈도우폰),ETC(WEB이나 기타 등등)
	queryParams += '&' + encodeURIComponent('MobileApp') + '=' + encodeURIComponent('AppTest'); //서비스 명
	queryParams += '&' + encodeURIComponent('arrange') + '=' + encodeURIComponent('B'); //정렬 기준 A=촬영일, B=제목, C=수정일, D=조회수
	queryParams += '&' + encodeURIComponent('keyword') + '=' + encodeURIComponent(place_name); //검색어
	queryParams += '&' + encodeURIComponent('_type') + '=' + encodeURIComponent('json'); //수신 데이터 타입
	xhr.open('GET', url + queryParams, false);
	xhr.onreadystatechange = function () {

		if (this.readyState == 4 && this.status == 200) {
//			console.log('Status: '+this.status+' nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
					
					//출력된 JSON객체 JavaScript객체로 변환
					var apiJson = JSON.parse(this.responseText);
					
					//없는 사진 불러올 경우 예외처리
					try{
						//사진 데이터
				    	mapImage = apiJson.response.body.items.item.galWebImageUrl;
					} catch {
						//api에 없는 데이터 수동으로 사진 넣어주기 includes 메소드 ES6이상 사용 가능
							if(place_name.includes('올레길')){
								mapImage = '/resources/images/mappicture/olleroad.jpg';
							} else if(place_name.includes('한라수목원')){
								mapImage = '/resources/images/mappicture/hanrasumok.jpg';
							} else if(place_name.includes('해수욕장') || place_name.includes('해변')){
								mapImage = '/resources/images/mappicture/jejubeaches.jpg';
							} else if(place_name.includes('오름')){
								mapImage = '/resources/images/mappicture/orum.jpg';
							} else if(place_name.includes('해안도로')){
								mapImage = '/resources/images/mappicture/beachroad.jpg';
							} else if(place_name.includes('전망대')){
								mapImage = '/resources/images/mappicture/observatory.jpg';
							} else {
								mapImage = '/resources/images/mappicture/default.jpg';
							}
					}
		 	}
		}
	xhr.send('');

};

