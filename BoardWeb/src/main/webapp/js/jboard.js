/**
 * jboard.js
 */
//수정버튼
document.querySelector('#modBtn').addEventListener('click', function() {
	document.forms.myFrm.action = "modBoardForm.do"; //수정화면 호출
	document.forms.myFrm.submit();
})


//삭제버튼
document.querySelector('.btn-danger').addEventListener('click', function() {
	document.forms.myFrm.action = "delBoardForm.do"; //삭제화면 호출
	document.forms.myFrm.submit();
})

//댓글목록 출력
let page = 1;
showList();
function showList() {
	//새로운 목록 출력할 경우 기존 목록 지우기
	$('div.content ul li:gt(2)').remove();
	
	svc.replyList({ bno: bno, page: page },
		result => {
			result.forEach(reply => {
				const row = makeRow(reply);
				row.appendTo('div.reply ul');
				})
				makePageInfo();
				},
				err => {console.log(err)})
	}

//삭제버튼 이벤트
function deleteRow(e) {
	const rno = $(e.target).parent().parent().data('rno'); //숫자 가져오기
	
	svc.removeReply(rno,
		result => {
			if (result.retCode == 'OK') {
				alert('삭제완료');
				showList();
			} else if (result.retCode == 'NG') {
				alert('삭제실패')
			} else {
				alert('알수없는 반환값')
			}
		}
		, err => cosnsole.log(err)
		)
}

//등록
$('#addReply').on('click',function(){
	let reply = $('#reply').val();
	if(!reply){
		alert('댓글을 입력하세요');
		return;
	}
	if(!writer){
		alert('로그인하세요');
		return;
	}
	svc.addReply({ bno,writer,reply },
		result => {
			if (result.retCode == 'OK') {
				page = 1;
				showList();
				$('#reply').val('');
			
			}
		}
		, err => console.log(err));
})


//row생성을 함수에 담은것
function makeRow(reply = {}) {
	let tmpl = $('div.reply li:nth-of-type(3)').clone();
	tmpl.css('display','block');
	tmpl.on('dblclick', function(e){
		
		//선택값을 모달창에 전달
		$('#myModal').css('display','block');
		let replyNo = $(e.target).parent().children().eq(0).text();
		let reply = $(e.target).parent().children().eq(1).text();
		$('.modal-content p:eq(0)').text('댓글번호 : ' +replyNo);
		$('.modal-content p:eq(1)').find('input').val(reply);
	})
	tmpl.attr('datsa-rno', reply.replyNo);
	tmpl.find('span:eq(0)').text(reply.replyNo);
	tmpl.find('span:eq(1)').text(reply.reply);
	tmpl.find('span:eq(2)').text(reply.replyer);
	return tmpl;
}

//페이징 생성
let pagination = $('div.pagination');

function  makePageInfo(){
	svc.getTotalCount(bno //param1
	,createPageList//param2
	,err=>console.log(err))
}

function createPageList(result) {
	
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;

	
	realEnd = Math.ceil(totalCnt / 5);

	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1;
	next = endPage < realEnd;

	console.log(startPage, endPage, realEnd, prev, next);

	//a태그 생성
	pagination.html(''); //초기값
	//이전페이지 여부
	if (prev) {
		let aTag = $('<a>&laquo;</a>').
		attr('href','#').
		attr('data-page',startPage -1);
		aTag.on('click',function(e){
			e.preventDefault(); //a태그는 페이지이동
			page = $(e.target).data('page'); 
			showList();
			})
		pagination.append(aTag);
		}
		
	for (let pg = startPage; pg <= endPage; pg++) {
		let aTag = $('<a />').html(pg)
		.attr('data-page', pg).
		attr('href', pg)
		
		if (pg == page) {
			aTag.attr('class','active');
		}
		aTag.on('click', function(e) {
			e.preventDefault(); //a태그는 페이지이동
			page = $(e.target).data('page'); 
			showList();
		})
		pagination.append(aTag);
	}
	//이후페이지 여부
	if (next) {
		let aTag = $('<a>&raquo;</a>').
		attr('href','#').
		attr('data-page',endPage +1);
		aTag.on('click',function(e){
			e.preventDefault(); //a태그는 페이지이동
			page = $(e.target).data('page'); 
			showList();
			})
		pagination.append(aTag);
		}
} //createPageList

//수정기능추가
$('.modal-content button').on('click',function(){
	let reply = $('.modal-content input').val();
	let rNm = $('.modal-content p:eq(0)').text();
	let rno = rNm.substr(7);
	
	console.log(rNm);
	console.log(reply);
	console.log(rno);
		svc.updateReply({ rno, reply },
		result => {
			if (result.retCode == 'OK') {
			
				alert('수정완료');
				$('#myModal').css('display','none');
				showList();
			
			}
		}
		, err => console.log(err));
})

	
		




