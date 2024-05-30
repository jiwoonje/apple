import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import './Store.css';
import Button from '../common/Button';

import Video from '../img/product_video.mp4';
import Slide1 from '../img/iphone_slide1.jpg';
import Slide2 from '../img/iphone_slide2.jpg';
import Slide3 from '../img/iphone_slide3.jpg';
import Slide4 from '../img/iphone_slide4.jpg';
import list1 from '../img/iphone_iphone15promax.png';
import list2 from '../img/iphone_iphone15pro.png';
import list3 from '../img/iphone_iphone15.png';
import duallens from '../img/iphone_2lens_icon.png';
import triplelens from '../img/iphone_3lens_icon.png';
import A17 from '../img/iphone_A17_icon.png';
import A16 from '../img/iphone_A16_icon.png';
import battery from '../img/iphone_battery_icon.png';

function Store() {

	const navigate = useNavigate();

    return (
		<div>
			<div className="wide_container">
				<div className="store_part1">
					<div className="store_title d-flex justify-content-between">
						<h1 className="store_title">라인업 살펴보기</h1>
					</div>
					<div className="text-center d-flex justify-content-around">
						<div className="store_list_part">
							<div className="store_list_img">
								<img src={list1} alt="" />
							</div>
							<div className="store_list_text">
								<p className="store_list_title">iPhone 15 Pro Max</p>
								<p className="store_list_subtitle">궁극의 iPhone.</p>
								<p className="store_list_price">￦ 1,900,000 부터</p>
							</div>
							<div className="store_list_button">
								<Button size={"small"} color={"blue"}text={"더 알아보기"}
									onClick={() => {navigate('/product_detail/1')}}></Button>
								<Button size={"small"} color={"none"} text={"구입하기"}
									onClick={() => {navigate('/store_detail/1')}}></Button>
							</div>
							<br />
							<hr />
							<div>
								<p className="store_title">17.0cm</p>
								<p className="store_spec_title">Super Retina</p>
								<p className="store_spec_title">XDR 디스플레이</p>
								<p className="store_spec_subtitle">Promotion 기술</p>
								<p className="store_spec_subtitle">상시표시형 디스플레이</p>
								<br />
							</div>
							<div>
								<img src={A17} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">A17 Pro 칩</p>
								<p className="store_spec_title">6코어 GPU 탑재</p>
								<br />
							</div>
							<div>
								<img src={triplelens} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">첨단 듀얼 카메라 시스템</p>
								<p className="store_spec_subtitle">애플 사상 가장 앞선 48MP 메인 카메라</p>
								<p className="store_spec_subtitle">3배 또는 5배 망원 지원</p>
								<p className="store_spec_subtitle">울트라 와이드 카메라</p>
								<br />
							</div>
							<div>
								<img src={battery} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">최대 29시간 동영상 재생</p>
								<br />	
							</div>
						</div>

						<div className="store_list_part">
							<div className="store_list_img">
								<img src={list2} alt="" />
							</div>
							<div className="store_list_text">
								<p className="store_list_title">iPhone 15 Pro</p>
								<p className="store_list_subtitle">막강한 성능</p>
								<p className="store_list_price">￦ 1,550,000 부터</p>
							</div>
							<div className="store_list_button">
								<Button size={"small"} color={"blue"}text={"더 알아보기"}
									onClick={() => {navigate('/product_detail/2')}}></Button>
								<Button size={"small"} color={"none"} text={"구입하기"}
									onClick={() => {navigate('/store_detail/2')}}></Button>
							</div>
							<br />
							<hr />
							<div>
								<p className="store_title">15.5cm</p>
								<p className="store_spec_title">Super Retina</p>
								<p className="store_spec_title">XDR 디스플레이</p>
								<p className="store_spec_subtitle">Promotion 기술</p>
								<p className="store_spec_subtitle">상시표시형 디스플레이</p>
								<br />
							</div>
							<div>
								<img src={A17} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">A17 Pro 칩</p>
								<p className="store_spec_title">6코어 GPU 탑재</p>
								<br />
							</div>
							<div>
								<img src={triplelens} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">첨단 듀얼 카메라 시스템</p>
								<p className="store_spec_subtitle">애플 사상 가장 앞선 48MP 메인 카메라</p>
								<p className="store_spec_subtitle">3배 또는 5배 망원 지원</p>
								<p className="store_spec_subtitle">울트라 와이드 카메라</p>
								<br />
							</div>
							<div>
								<img src={battery} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">최대 23시간 동영상 재생</p>
								<br />
							</div>
						</div>

						<div className="store_list_part">
							<div className="store_list_img">
								<img src={list3} alt="" />
							</div>
							<div className="store_list_text">
								<p className="store_list_title">iPhone 15</p>
								<p className="store_list_subtitle">여전한 놀라움.</p>
								<p className="store_list_price">￦ 1,250,000 부터</p>
							</div>
							<div className="store_list_button">
								<Button size={"small"} color={"blue"}text={"더 알아보기"}
									onClick={() => {navigate('/product_detail/3')}}></Button>
								<Button size={"small"} color={"none"} text={"구입하기"}
									onClick={() => {navigate('/store_detail/3')}}></Button>
							</div>
							<br />
							<hr />
							<div>
								<p className="store_title">15.5cm</p>
								<p className="store_spec_title">Super Retina</p>
								<p className="store_spec_title">XDR 디스플레이</p>
								<p className="store_spec_subtitle">-</p>
								<p className="store_spec_subtitle">-</p>
								<br />
							</div>
							<div>
								<img src={A16} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">A16 Bionic 칩</p>
								<p className="store_spec_title">5코어 GPU 탑재</p>
								<br />
							</div>
							<div>
								<img src={duallens} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">첨단 듀얼 카메라 시스템</p>
								<p className="store_spec_subtitle">48MP 메인 카메라</p>
								<p className="store_spec_subtitle">2배 망원 지원</p>
								<p className="store_spec_subtitle">울트라 와이드 카메라</p>
								<br />
							</div>
							<div>
								<img src={battery} className="store_spec_img" alt="" />
							</div>
							<div>
								<p className="store_spec_title">최대 20시간 동영상 재생</p>
								<br />	
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default Store;