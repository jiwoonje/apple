import { BrowserRouter } from "react-router-dom";

import Header from "./common/Header";
import Main from "./common/Main";
import Footer from "./common/Footer";
import ScrollToTop from "./context/ScrollToTop";
import AuthProvider from "./context/AuthProvider";
import HttpHeadersProvider from "./context/HttpHeadersProvider"; // 여기까지가 페이지에 구성할 Component들 불러오기

function App() {


  return (
    <div>
      <BrowserRouter>               {/* 현재 Browser에서 Request & Response가 발생할 경우 처리 */}
        <AuthProvider>              {/* 회원 정보 인증(Id, pw) */}
          <HttpHeadersProvider>     {/* 회원 정보 인증(JWT) */}
            <Header />     
            <ScrollToTop>           {/* 화면 바뀔 때 스크롤을 최 상단으로 */}
              <Main />                {/* 화면에 띄울 페이지 */}
            </ScrollToTop>
            <Footer />
          </HttpHeadersProvider>
        </AuthProvider>
      </BrowserRouter>
    </div>
  );
}

export default App;
