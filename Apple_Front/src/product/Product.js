import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import './Product.css';
import Button from '../common/Button';

import Video from '../img/product_video.mp4';
import Slide1 from '../img/iphone_slide1.jpg';
import Slide2 from '../img/iphone_slide2.jpg';
import Slide3 from '../img/iphone_slide3.jpg';
import Slide4 from '../img/iphone_slide4.jpg';
import lineup1 from '../img/iphone_iphone15promax.png';
import lineup2 from '../img/iphone_iphone15pro.png';
import lineup3 from '../img/iphone_iphone15.png';
import duallens from '../img/iphone_2lens_icon.png';
import triplelens from '../img/iphone_3lens_icon.png';
import A17 from '../img/iphone_A17_icon.png';
import A16 from '../img/iphone_A16_icon.png';
import battery from '../img/iphone_battery_icon.png';

function Product() {


    return (
		<div>
			<div className="wide_container">
				<div className="part1">
					<div className="part_title d-flex justify-content-between">
						<h1 className="product_title">iPhone</h1>
						<p className="product_subtitle">사랑받기 위해 디자인되다.</p>
					</div>
					<div className="video_part">
						<video
							muted autoPlay loop className="video_item">
							<source src={Video} type="video/mp4" />
						</video>
					</div>
				</div>

				<div className="part2">
					<div className="part_title d-flex justify-content-between">
						<h1 className="product_title">알면 알수록, iPhone</h1>
					</div>
					<div className="text-center d-flex justify-content-between">
						<div className="slide_part">
							<div className="slide_img">
								<img src={Slide1} alt="" />
							</div>
							<div className="slide_text">
								<p className="slide_title">첨단 카메라</p>
								<p className="slide_subtitle">셀피 장인부터</p>
								<p className="slide_subtitle">영상 제작자,</p>
								<p className="slide_subtitle">경계 파괴자까지.</p>
							</div>
						</div>
						<div className="slide_part">
							<div className="slide_img">
								<img src={Slide2} alt="" />
							</div>
							<div className="slide_text">
								<p className="slide_title">Apple 제작 칩</p>
								<p className="slide_subtitle">매번 실감하는 속도.</p>
							</div>
						</div>
						<div className="slide_part">
							<div className="slide_img">
								<img src={Slide3} alt="" />
							</div>
							<div className="slide_text">
								<p className="slide_title">배터리</p>
								<p className="slide_subtitle">탁월한 배터리 사용 시간이란</p>
								<p className="slide_subtitle">이런 것.</p>
							</div>
						</div>
					</div>
				</div>
				<div className="part3">
					<div className="part_title d-flex justify-content-between">
						<h1 className="product_title">라인업 살펴보기</h1>
					</div>
					<div className="text-center d-flex justify-content-around">
						<div className="lineup_part">
							<div className="lineup_img">
								<img src={lineup1} alt="" />
							</div>
							<div className="lineup_text">
								<p className="lineup_title">iPhone 15 Pro Max</p>
								<p className="lineup_subtitle">궁극의 iPhone.</p>
								<p className="lineup_price">￦ 1,550,000 부터</p>
							</div>
							<div>
								<Button size={"small"} color={"blue"}text={"더 알아보기"}></Button>
								<Button size={"small"} color={"none"} text={"구입하기"}></Button>
							</div>
						</div>
						<div className="lineup_part">
							<div className="lineup_img">
								<img src={lineup2} alt="" />
							</div>
							<div className="lineup_text">
								<p className="lineup_title">iPhone 15 Pro</p>
								<p className="lineup_subtitle">막강한 성능</p>
								<p className="lineup_price">￦ 1,250,000 부터</p>
							</div>
							<div>
								<Button size={"small"} color={"blue"}text={"더 알아보기"}></Button>
								<Button size={"small"} color={"none"} text={"구입하기"}></Button>
							</div>
						</div>
						<div className="lineup_part">
							<div className="lineup_img">
								<img src={lineup3} alt="" />
							</div>
							<div className="lineup_text">
								<p className="lineup_title">iPhone 15</p>
								<p className="lineup_subtitle">여전한 놀라움.</p>
								<p className="lineup_price">￦ 1,090,000 부터</p>
							</div>
							<div>
								<Button size={"small"} color={"blue"}text={"더 알아보기"}></Button>
								<Button size={"small"} color={"none"} text={"구입하기"}></Button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default Product;