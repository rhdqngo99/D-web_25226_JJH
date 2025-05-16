import React from 'react';
import dayjs from 'dayjs';
import { DateWrap } from '../style';
import { useSelector } from 'react-redux';

const Header = () => {

    const done = useSelector((state) => state.post.filter((v) => v.done === false));

    const date = dayjs(new Date());
    return (
    <DateWrap>
        <h1>{date.format('YYYY년 MM월 DD일')}</h1>
        <p>오늘 할 일 {done.length}개 남음</p>
    </DateWrap>
    );
};

export default Header;