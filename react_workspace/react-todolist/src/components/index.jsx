import shortId from 'shortid';
import produce from 'immer';
export const ADD_TODO_LIST = 'ADD_TODO_LIST';
export const REMOVE_TODO_LIST = 'REMOVE_TODO_LIST';
export const CHANGE_TODO_LIST = 'CHANGE_TODO_LIST';

const initialState = {
    post: [
        {
            id: shortId.generate(),
            title: '자바스크립트 공부하기',
            done: true
        },
        {
            id: shortId.generate(),
            title: '리액트 공부하기',
            done: false
        },
        {
            id: shortId.generate(),
            title: '노드 공부하기',
            done: false
        },
    ],
};

const todoReducer = (state = initialState, action) => {
    return produce(state, (draft) => {
        switch (action.type) {
            case ADD_TODO_LIST:
                draft.post.unshift(action.payload);
        break;
            case REMOVE_TODO_LIST:
                draft.post = draft.post.filter((v) => v.id !== action.payload);
        break;
            case CHANGE_TODO_LIST:

        const post = draft.post.find((v) => v.id === action.payload.id);

        post.title = action.payload.title;
        break;
        default:
            return state;
        }
    })
};

export default todoReducer;