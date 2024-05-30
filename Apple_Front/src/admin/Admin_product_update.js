import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

import Button from '../common/Button';


function Admin_product_update() {
   
    const { headers, setHeaders } = useContext(HttpHeadersContext);
	const { auth, setAuth } = useContext(AuthContext);
    const navigate = useNavigate();

    const location = useLocation();
	const { product } = location.state;

    const [prodSeq, setProdSeq] = useState(product.prodSeq);
    const [prodName, setProdName] = useState(product.prodName);
    const [prodPrice, setProdPrice] = useState(product.prodPrice);
    const [prodCnt, setProdCnt] = useState(product.prodCnt);
    const [hddSeq, setHddSeq] = useState(product.hddSeq);
    const [colorSeq, setColorSeq] = useState(product.colorSeq);

    const changeProdSeq = (event) => {setProdSeq(event.target.value);};
    const changeProdName = (event) => {setProdName(event.target.value);};
    const changeProdPrice = (event) => {setProdPrice(event.target.value);};
    const changeProdCnt = (event) => {setProdCnt(event.target.value);};
    const changeHddSeq = (event) => {setHddSeq(event.target.value);};
    const changeColorSeq = (event) => {setColorSeq(event.target.value);};

    /* product 수정 */
    const updateProduct = async () => {

        const req = {
            prodSeq: prodSeq,
            prodName: prodName,
            prodPrice: prodPrice,
            prodCnt: prodCnt,
            hddSeq: hddSeq,
            colorSeq: colorSeq
        }

        await axios
            .patch(`http://localhost:3000/admin/product/update/${product.prodSeq}`, req, {headers: headers})
            .then((resp) => {
                console.log("[Admin_product_updqte.js] updateProduct() success :D");
                console.log(resp.data);

                if (resp.data.updatedProduct == 1) {
                    alert("상품을 성공적으로 수정했습니다 :D");
                    navigate(`/admin/product/getOne/${product.prodSeq}`); // 글 상세로 이동
                }
            })
            .catch((err) => {
                console.log("[Admin_product_updqte.js] updateProduct() error :<");
                console.log(err);
            });
    };

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">상품 수정</h1>                    
                    </div>
                    <div className="admin_product part1">
                        <div>
                            <h2 className="admin_product_subtitle">Product</h2>
                        </div>
                        <div>
                            <table className="create_table">
                                <tbody>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 모델명</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={prodSeq} onChange={changeProdSeq}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 이름</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={prodName} onChange={changeProdName}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 가격</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={prodPrice} onChange={changeProdPrice}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">수량</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={prodCnt} onChange={changeProdCnt}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">용량</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={hddSeq} onChange={changeHddSeq}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">색상</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={colorSeq} onChange={changeColorSeq}></input>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}></Button>
                        <Button size={"default"} color={"blue"} text={"수정하기"}
                            onClick={updateProduct}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_product_update;