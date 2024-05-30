import { Link } from 'react-router-dom';
import React, { useState, useContext } from "react";
import { useNavigate } from 'react-router-dom';
import './Home.css';
import homeimg1 from '../img/home_iphone15promax.png';
import homeimg2 from '../img/home_iphone15pro.png';
import homeimg3 from '../img/home_iphone15.png';
import Button from '../common/Button';

const Home = () => {
	
	const navigate = useNavigate();

	return (
		<div className="main container-fluid">
			<div className="home1">
				<img src={homeimg1} alt=""/>
				<div className="hometext1">
					<h3 className="maintitle">iPhone 15 Pro Max</h3>
					<p className="mainsubtitle">티타늄. 초강력. 초경량. 초프로.</p>
				</div>
				<div className="homebtn1">
					<Button size={"default"} color={"blue"}text={"더 알아보기"}
						onClick={() => {navigate('/product_detail/1')}}></Button>
					<Button size={"default"} color={"none"} text={"구입하기"}
						onClick={() => {navigate('/store_detail/1')}}></Button>
				</div>
			</div>
			<div className="home2">
				<img src={homeimg2} alt="" />
				<div className="hometext2">
					<h3 className="maintitle">iPhone 15 Pro</h3>
					<p className="mainsubtitle">티타늄. 초강력. 초경량. 초프로.</p>
				</div>
				<div className="homebtn2">
					<Button size={"default"} color={"blue"}text={"더 알아보기"}
						onClick={() => {navigate('/product_detail/2')}}></Button>
					<Button size={"default"} color={"none"} text={"구입하기"}
						onClick={() => {navigate('/store_detail/2')}}></Button>
				</div>
			</div>
			<div className="home3">
				<img src={homeimg3} alt="" />
				<div className="hometext3">
					<h3 className="maintitle">iPhone 15</h3>
					<p className="mainsubtitle">티타늄. 초강력. 초경량. 초프로.</p>
				</div>
				<div className="homebtn3">
					<Button size={"default"} color={"blue"}text={"더 알아보기"}
						onClick={() => {navigate('/product_detail/3')}}></Button>
					<Button size={"default"} color={"none"} text={"구입하기"}
						onClick={() => {navigate('/store_detail/3')}}></Button>
				</div>
			</div>
		</div>
	
	);
}

export default Home;