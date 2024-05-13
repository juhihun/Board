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

fetch('replyList.do?bno=' + bno)
.then(resolve => resolve.json()) //json ->객체
.then(result =>{
	
	console.log(result);
	result.forEach(reply =>{
		let tmpl = document.querySelector('div.reply li:nth-of-type(3)').cloneNode(true);
		console.log(tmpl);
		tmpl.style.display = 'block';
		tmpl.setAttribute('data-rno',reply.replyNo);
		tmpl.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
		tmpl.querySelector('span:nth-of-type(2)').innerText = reply.reply;
		tmpl.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
		document.querySelector('div.reply ul').appendChild(tmpl);
	})
})
.catch(err=>{
	console.log(err);
})

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
			 e.target.parentElement.parentElement.remove();
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
			location.reload();
		}
	})
	.catch(err => console.log(err));
})




