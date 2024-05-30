import { Link } from 'react-router-dom';
import React, { useState, useContext } from "react";
import { useNavigate } from 'react-router-dom';
import './Store.css';
import i15pro from '../img/iphone_iphone15pro_large.png';
import Button from '../common/Button';
import lineup1 from '../img/iphone_iphone15promax.png';
import lineup2 from '../img/iphone_iphone15pro.png';
import lineup3 from '../img/iphone_iphone15.png';

function Store_Detail_2() {

    const [x, setX] = useState([]);
    const [y, setY] = useState([]);

    const handleClickRadioButton = (e) => {
        console.log(e.target.value)
        setX(e.target.value)
    }

    const handleClickRadioButton2 = (e) => {
        console.log(e.target.value)
        setY(e.target.value)
    }
    
    const navigate = useNavigate();

    return (
        <div className="store_detail_bg">
            <div className="container">
                <div className="store_detail_part1">
                    <div>
                        <h1 className="store_detail_title">iPhone 15 Pro 구매하기</h1>
                        <p className="store_detail_subtitle">1,550,000 부터</p>

                    </div>
                </div>

                <div className="store_detail_part2 d-flex justify-content-between">
                    <div className="store_detail_left">
                        <img src={i15pro} alt="" className="store_detail_left_img" />
                    </div>
                    <div className="store_detail_right">
                        <div className="store_detail_name">
                            <h1 className="store_detail_name_item">iPhone 15 Pro</h1>
                        </div>
                        <div>
                            <p className="store_detail_option">저장 용량을 선택하세요.</p>
                        </div>
                        <div className="store_detail_hdd d-flex justify-content-between">
                            <div>
                                <input type="radio" value="256" className="store_radio_check"
                                    checked={x === "256"} onChange={handleClickRadioButton} />
                                <label className="store_radio_label"> 256G </label>
                            </div>
                            <div>
                                <input type="radio" value="512" className="store_radio_check"
                                    checked={x === "512"} onChange={handleClickRadioButton} />
                                <label className="store_radio_label"> 512G </label>
                            </div>
                        </div>
                        <div>
                            <p className="store_detail_option">색상을 선택하세요.</p>
                        </div>
                        <div className="store_detail_color d-flex justify-content-between">
                            <div>
                                <input type="radio" value="blue" className="store_radio_check"
                                    checked={y === "blue"} onChange={handleClickRadioButton2} />
                                <label className="store_radio_label"> 블루 </label>
                            </div>
                            <div>
                                <input type="radio" value="pink" className="store_radio_check"
                                    checked={y === "pink"} onChange={handleClickRadioButton2} />
                                <label className="store_radio_label"> 핑크 </label>
                            </div>
                            <div>
                                <input type="radio" value="black" className="store_radio_check"
                                    checked={y === "black"} onChange={handleClickRadioButton2} />
                                <label className="store_radio_label"> 블랙 </label>
                            </div>
                        </div>
                        <div className="store_detail_btn d-flex justify-content-center">
                            <Button size={"default"} color={"none"}text={"카트에 담기"}
                                onClick={() => {navigate('/cart')}}></Button>
                            <Button size={"default"} color={"blue"}text={"결제하기"}
                                onClick={() => {navigate('/payment')}}></Button>
                        </div>
                    </div>
                </div>

                <div className="store_detail_part2">
                    <div className="store_detail_part3_1 d-flex justify-content-between">
                        <h1 className="store_detail_part3_title">라인업 살펴보기</h1>
                    </div>
                    <div className="text-center d-flex justify-content-around">
                        <div className="store_detail_lineup_part">
                            <div className="store_detail_lineup_img">
                                <img src={lineup1} alt="" />
                            </div>
                            <div className="store_detail_lineup_text">
                                <p className="store_detail_lineup_title">iPhone 15 Pro Max</p>
                                <p className="store_detail_lineup_subtitle">궁극의 iPhone.</p>
                                <p className="store_detail_lineup_price">￦ 1,550,000 부터</p>
                            </div>
                            <div>
                                <Button size={"small"} color={"blue"} text={"더 알아보기"}
                                    onClick={() => {navigate('/product_detail/1')}}></Button>
                                <Button size={"small"} color={"none"} text={"구입하기"}
                                    onClick={() => {navigate('/store_detail/1')}}></Button>
                            </div>
                        </div>
                        <div className="store_detail_lineup_part">
                            <div className="store_detail_lineup_img">
                                <img src={lineup2} alt="" />
                            </div>
                            <div className="store_detail_lineup_text">
                                <p className="store_detail_lineup_title">iPhone 15 Pro</p>
                                <p className="store_detail_lineup_subtitle">막강한 성능</p>
                                <p className="store_detail_lineup_price">￦ 1,250,000 부터</p>
                            </div>
                            <div>
                                <Button size={"small"} color={"blue"} text={"더 알아보기"}
                                    onClick={() => {navigate('/product_detail/2')}}></Button>
                                <Button size={"small"} color={"none"} text={"구입하기"}
                                    onClick={() => {navigate('/store_detail/2')}}></Button>
                            </div>
                        </div>
                        <div className="store_detail_lineup_part">
                            <div className="store_detail_lineup_img">
                                <img src={lineup3} alt="" />
                            </div>
                            <div className="store_detail_lineup_text">
                                <p className="store_detail_lineup_title">iPhone 15</p>
                                <p className="store_detail_lineup_subtitle">여전한 놀라움.</p>
                                <p className="store_detail_lineup_price">￦ 1,090,000 부터</p>
                            </div>
                            <div>
                                <Button size={"small"} color={"blue"} text={"더 알아보기"}
                                    onClick={() => {navigate('/product_detail/3')}}></Button>
                                <Button size={"small"} color={"none"} text={"구입하기"}
                                    onClick={() => {navigate('/store_detail/3')}}></Button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Store_Detail_2;