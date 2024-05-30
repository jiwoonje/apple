import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import Button from '../common/Button';
import i15video1 from "../img/product_detail_iphone15_video1.mp4";
import i15img1 from "../img/iphone_A16.png";
import i15img2 from "../img/product_detail_iphone15_color.jpg";
import i15img3 from "../img/product_detail_iphone15_camera.png";
import i15img4 from "../img/product_detail_iphone15_island.jpg";
import lineup1 from '../img/iphone_iphone15promax.png';
import lineup2 from '../img/iphone_iphone15pro.png';
import lineup3 from '../img/iphone_iphone15.png';


function Product_Detail_3() {

	const navigate = useNavigate();

    return (
		<div>
			<div className="product_detail3_container">
				<div className="product_detail3_part1">
					<div className="product_detail3_video">
						<video
							muted autoPlay loop className="product_detail3_video_item">
							<source src={i15video1} type="video/mp4" />
						</video>
					</div>
					<div className="d-flex justify-content-center">
						<Button size={"small"} color={"blue"} text={"구입하기"}
							onClick={() => {navigate('/store_detail/3')}}></Button>
					</div>
					<div className="d-flex justify-content-center">
						<h1 className="product_detail3_price">￦1,250,000부터</h1>
					</div>
				</div>

				<div className="product_detail3_part2">
					<div className="wide_container">
						<h1 className="product_detail3_part3_title">A16 Bionic 칩.</h1>
					</div>
					<div className="d-flex justify-content-center">
						<img src={i15img1} alt="" />
					</div>
				</div>

				<div className="product_detail3_part3">
					<div className="wide_container">
						<h1 className="product_detail3_part3_title">다양한 색상.</h1>
					</div>
					<div className="d-flex justify-content-center">
						<img src={i15img2} alt="" />
					</div>
				</div>

				<div className="product_detail3_part4">
					<div className="wide_container">
						<h1 className="product_detail3_part4_title">iPhone.</h1>
						<h1 className="product_detail3_part4_title">구석구석 견고한 글래스.</h1>
						<div className="d-flex justify-content-center">
							<img src={i15img3} alt="" className="product_detail_img_top" />
						</div>
					</div>
				</div>

				<div className="product_detail3_part4">
					<div className="wide_container">
						<h1 className="product_detail3_part4_title">Dynamic Island.</h1>
						<h1 className="product_detail3_part4_title">그때그때 요긴하게 두둥실.</h1>
						<div className="d-flex justify-content-center">
							<img src={i15img4} alt="" className="product_detail_img_top" />
						</div>
					</div>
				</div>
			</div>

			<div className="product_detail1_part5">
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
						<div className="store_list_button">
							<Button size={"small"} color={"blue"}text={"더 알아보기"}
								onClick={() => {navigate('/product_detail/1')}}></Button>
							<Button size={"small"} color={"none"} text={"구입하기"}
								onClick={() => {navigate('/store_detail/1')}}></Button>
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
						<div className="store_list_button">
							<Button size={"small"} color={"blue"}text={"더 알아보기"}
								onClick={() => {navigate('/product_detail/2')}}></Button>
							<Button size={"small"} color={"none"} text={"구입하기"}
								onClick={() => {navigate('/store_detail/2')}}></Button>
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
						<div className="store_list_button">
							<Button size={"small"} color={"blue"}text={"더 알아보기"}
								onClick={() => {navigate('/product_detail/3')}}></Button>
							<Button size={"small"} color={"none"} text={"구입하기"}
								onClick={() => {navigate('/store_detail/3')}}></Button>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
    
    }
    
    export default Product_Detail_3;