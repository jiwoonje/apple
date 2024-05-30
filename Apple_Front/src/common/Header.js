import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext} from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

import './Header.css';
import Logo from '../img/apple_logo_white.png';

function Header() {

	const { auth, setAuth } = useContext(AuthContext);

	console.log ("auth 정보 : " , auth);


	return (
		<header className="py-4">
			<div className="container navbar">
  				<Link to="/"><img src={Logo} alt="" className="headerLogo"/></Link>
  				<Link to="/store">스토어</Link>
				
  				{/* <Link to="/payment_test">결제</Link> */}
  				
				<Link to="/product">iPhone</Link>
				<div class="dropdown">
					<div className="dropdown-toggle nav_hover" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Series</div>
    				<div className="dropdown-menu" aria-labelledby='navbarDropdown'>
      					<Link className="dropdown-item" to="/product_detail/1">iPhone 15 pro max</Link>
      					<Link className="dropdown-item" to="/product_detail/2">iPhone 15 pro</Link>
      					<Link className="dropdown-item" to="/product_detail/3">iPhone 15</Link>
    				</div>
				</div>
  				<Link to="/cart">장바구니</Link>
				{
					(auth) ?
					<>
						<div class="dropdown">
							<div className="dropdown-toggle nav_hover" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> {auth}님 로그인 중
							</div>
							<div className="dropdown-menu" aria-labelledby='navbarDropdown'>
								<Link className="dropdown-item" to={{ pathname: `/mypage/${auth}`}}>마이페이지</Link>
								<Link className="dropdown-item" to="/mypage/payment">결제 내역</Link>
							</div>
						</div>
					</>
					:
					<>
					</>
				}

				{
					(auth=='admin') ?
					<>
						<div class="dropdown">
							<div className="dropdown-toggle nav_hover" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">관리자 페이지
							</div>
							<div className="dropdown-menu" aria-labelledby='navbarDropdown'>
								<Link className="dropdown-item" to="/admin/product">상품 관리</Link>
								<Link className="dropdown-item" to="/admin/product/create">상품 등록</Link>
								<Link className="dropdown-item" to="/admin/payment">결제 내역</Link>
								<Link className="dropdown-item" to="/admin/member">회원 관리</Link>
							</div>
						</div>
					</>
					:
					<>
					</>
				}
			
			</div>
		</header>
	);
}

export default Header;