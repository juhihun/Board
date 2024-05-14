/**
 * board.js
 */
//수정버튼
document.querySelector('#modBtn').addEventListener('click', function(){
	document.forms.myFrm.action = "modBoardForm.do"; //수정화면 호출
	document.forms.myFrm.submit();
})


//삭제버튼
document.querySelector('.btn-danger').addEventListener('click', function(){
		document.forms.myFrm.action = "delBoardForm.do"; //삭제화면 호출
		document.forms.myFrm.submit();
})

//댓글목록 출력
//const bno = 645;
console.log('bno:' + bno);
let page = 1;
showList();
function showList(){
	//댓글목록 초기화
	document.querySelectorAll('div.content ul li').forEach((li,idx) => {
		if(idx >= 3){
			li.remove();
		}
	})
fetch('replyList.do?bno=' + bno + '&page=' + page)
.then(resolve => resolve.json()) //json ->객체
.then(result =>{
	console.log(result);
	result.forEach(reply =>{
		const row = makeRow(reply);
		document.querySelector('div.reply ul').appendChild(row);
	})
	createPageList();
})
.catch(err=>{
	console.log(err);
})

}

//삭제버튼 이벤트
function deleteRow(e){
	const rno = e.target.parentElement.parentElement.dataset.rno; //숫자 가져오기
	console.log(rno);
	
	//삭제기능구현 fetch
	fetch('removeReply.do?rno='+rno)
	.then(resolve => resolve.json())
	.then(result => {
		if(result.retCode =='OK'){
			alert('삭제완료');
			// e.target.parentElement.parentElement.remove();
			showList();
		}else if(result.retCode =='NG'){
			alert('삭제실패')
		}else{
			alert('알수없는 반환값')
		}
	})
	.catch(err => cosnsole.log(err));
	}
	
//등록
document.getElementById('addReply').addEventListener('click',function(e){
	
	//fetch
	let reply = document.getElementById('reply').value;
	fetch('addReply.do?bno='+bno+'&replyer='+writer+'&reply='+reply)
	.then(resolve => resolve.json())
	.then(result =>{
		if(result.retCode == 'OK'){
			//location.reload();
			const row = makeRow(result.retVal);
			document.querySelector('div.reply ul').appendChild(row);
		}
	})
	.catch(err => console.log(err));
})

//row생성을 함수에 담은것
function makeRow(reply = {}){
let tmpl = document.querySelector('div.reply li:nth-of-type(3)').cloneNode(true);
		console.log(tmpl);
		tmpl.style.display = 'block';
		tmpl.setAttribute('data-rno',reply.replyNo);
		tmpl.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
		tmpl.querySelector('span:nth-of-type(2)').innerText = reply.reply;
		tmpl.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
		return tmpl;
}

//페이징 생성
let pagination = document.querySelector('div.pagination');

function createPageList(){
	let totlaCnt = 100;
	let startPage, endPage, realEnd;
	let prev,next;
	
	realEnd = Math.ceil(totlaCnt / 5);
	
	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage -4;
	endPage = endPage > realEnd ? realEnd : endPage;
	
	prev = startPage > 1;
	next = endPage < realEnd;
	
	console.log(startPage, endPage, realEnd, prev, next);
	
	//a태그 생성
	pagination.innerHTML = '';
	//이전페이지 여부
	if(prev){
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page',startPage-1);
		aTag.setAttribute('href','#');
		aTag.innerHTML = "&laquo;";  //<표시
		pagination.appendChild(aTag);
		aTag.addEventListener('click',function(e){
			e.preventDefault(); //a태그는 페이지이동
			
			page = e.target.dataset.page; //
			showList();
		})
		pagination.appendChild(aTag);
	}
	for(let pg = startPage; pg <= endPage; pg++){
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page',pg);
		aTag.setAttribute('href','#');
		if(pg == page){
			aTag.className = 'active';
		}
		aTag.innerHTML = pg;
		aTag.addEventListener('click',function(e){
			e.preventDefault(); //a태그는 페이지이동
			
			page = e.target.dataset.page; //
			showList();
		})
		pagination.appendChild(aTag);
	}
	//이후페이지 여부
	if(next){
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page',endPage + 1);
		aTag.setAttribute('href','#');
		aTag.innerHTML = "&raquo;";  //>표시
		pagination.appendChild(aTag);
		aTag.addEventListener('click',function(e){
			e.preventDefault(); //a태그는 페이지이동
			
			page = e.target.dataset.page; //
			showList();
		})
		pagination.appendChild(aTag);
	}
}



