import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import './App.css';
import App from './App';                          // App component import
import reportWebVitals from './reportWebVitals';  // Web Page의 성능 파악을 위해 사용(없어도 된다.)
import "./font/Font.css";

const root = ReactDOM.createRoot(document.getElementById('root'));  // Browser에서 보여줄 화면을 출력하기 위해 ReactDOM을 이용해 root라는 아이디로 생성
root.render(                                                        // React Element Rendering - 화면에 출력
  // <React.StrictMode>
    <App />                                                         // React에서 동작하는 모든 Component가 App.js에서 동작하므로, 여기에서 처리된 결과를 index.js에서 보여준다.
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
