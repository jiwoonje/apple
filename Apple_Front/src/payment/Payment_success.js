import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import Button from '../common/Button';

function Payment_success() {

	const navigate = useNavigate();

	const today = new Date();
	const formattedDate = `${today.getFullYear()}년 ${today.getMonth() + 1}월 ${today.getDate()+2}일`;


    return (
		<div>
			<div className="container">
				<div className="payment_success_part">
					<div>
						<h1 className="payment_success_title"> 구매해주셔서 감사합니다. </h1>
					</div>
					<div>
						<h1 className="payment_success_subtitle">{formattedDate} 이내에 배송됩니다.</h1>
					</div>
					
					<hr />
					
					<div className="payment_success_part_1 d-flex justify-content-between">
						<div>
							<h1 className="payment_success_detail">iPhone15</h1>
							<h1 className="payment_success_detail">256G</h1>
							<h1 className="payment_success_detail">블루</h1>
						</div>
						<div>
							<h1 className="payment_success_detail">￦ 1,250,000</h1>
						</div>
						<div>
							<h1 className="payment_success_detail">무료 배송</h1>
						</div>
						<div>
							<h1 className="payment_success_detail">도착 예정일 : {formattedDate}</h1>
						</div>
					</div>

					<div className="payment_success_part_1 d-flex justify-content-center">
						<Button size={"default"} color={"none"} text={"홈으로"}
							onClick={() => navigate('/')}></Button>
						<Button size={"large"} color={"blue"} text={"결제내역 확인하기"}
							onClick={() => navigate('/mypage/payment')}></Button>
					</div>
				</div>

			</div>
		</div>
	);
    
    }
    
    export default Payment_success;