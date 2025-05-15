// 설치한 라이브러리 변수로 받아오기
const express = require('express');
const bodyParser= require('body-parser');
const mysql = require('mysql');
const cors = require('cors');

// express 사용하기 위한 app  생성
const app = express();

// express 서버 port 설정
const PORT = 5000;
// const PORT = process.env.PORT || 5000;

app.use(cors());
app.use(bodyParser.json());

// mysql 접속
const db = mysql.createConnection({
    host: 'localhost',
    user: 'reactUser',
    password: 'mysql',
    port: '3306',
    database: 'react_board'
});

// express 접속
app.listen(PORT, ()=>{
    console.log(`server connecting on : http://localhost:${PORT}`)
});

// mysql 연결
db.connect((err)=>{
    if(!err){
        console.log('success');
    }else{
        console.log('fail');
    }
});

// root 기본 연결시 보여지는 기본 화면 설정
app.get('/', (req, res) => {
    res.send("Hello React World~!!");
});

// boardList 불러오기 
app.get('/list', (req, res) => {
    const sql='select * from board order by id desc';
    db.query(sql, (err, data) => {
        if(!err){
            res.send(data);
        }else{
            console.log(err);
            res.send('전송오류');
        }
    })
});

app.get(`/view/:id`,(req, res)=>{
    // 파라미터 가져오기
    const id = req.params.id;

    const sql = `select * from board where id = ${id}`;
    db.query(sql, (err, data)=>{
        if(!err){
            res.send(data);
        }else{
            console.log(err);
            res.send('error');
        }
    })
});

// 게시글 등록 post
app.post('/insert',(req, res)=>{
    const { title, writer, content } = req.body;

    const sql = `insert into board(title, writer, contents) values (?,?,?)`;
    db.query(sql, [title, writer, content], (err, data)=>{
        if(!err){
            console.log(data);
            res.sendStatus(200);
        }else{
            console.log(err);
        }
    })
})

// 게시글 수정
app.post(`/update/:id`,(req, res)=>{
    // 파라미터 가져오기
    const id = req.params.id;
    const { title, writer, contents } = req.body;

    const sql = 'update board set title=?, writer=?, contents=? where id=?';
    db.query(sql, [title, writer, contents, id],(err, data)=>{
        if(!err){
            console.log(data);
            res.sendStatus(200);
        }else{
            console.log(err);
        }
    })
})