import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";

import Button from '../common/Button';


function Admin_product_detail() {

    const { auth, setAuth } = useContext(AuthContext)
    const [product, setProduct] = useState({});
    const {prodSeq} = useParams();

    const navigate = useNavigate();

    /* product 1개 불러오기 */
    const findByIdProduct = async () => {

		await axios.get(`http://localhost:3000/admin/product/getOne/${prodSeq}`)
		.then((resp) => {
			console.log("[Admin_product_detail.js] findByIdProduct() success :D");
			console.log(resp.data);
            setProduct(resp.data);

		})
		.catch((err) => {
			console.log("[Admin_product_detail.js] findByIdProduct() error :<");
			console.log(err);
		});
	}

    useEffect(() => {
		findByIdProduct();
	}, []);

    const updateProduct = {
		prodSeq: product.prodSeq,
        prodName: product.prodName,
        prodPrice: product.prodPrice,
        prodCnt: product.prodCnt,
        hddSeq: product.hddSeq,
        colorSeq: product.colorSeq,
	}

    const moveUpdate = (event) => {
        navigate(`/admin/product/update/${prodSeq}`, {
            state : {data : product}
        });
    }

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">상품 정보 자세히 보기</h1>                    
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
                                            <span>{product.prodSeq}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 이름</th>
                                        <td className="create_td">
                                            <span>{product.prodName}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">상품 가격</th>
                                        <td className="create_td">
                                            <span>{product.prodPrice}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">수량</th>
                                        <td className="create_td">
                                            <span>{product.prodCnt}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">용량</th>
                                        <td className="create_td">
                                            <span>{product.hddSeq}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">색상</th>
                                        <td className="create_td">
                                            <span>{product.colorSeq}</span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}></Button>
                        <Link to="/admin/product/update/${prodSeq}"
                            state={{ product: updateProduct}} >
                            <Button size={"default"} color={"blue"} text={"수정하기"} ></Button>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_product_detail;