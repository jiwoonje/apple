import axios from "axios";
import { Link, useParams, useLocation, useNavigate } from "react-router-dom";
import Pagination from "react-js-pagination";
import Button from '../common/Button';
import React, { useState, useContext, useEffect } from "react";
import { AuthContext } from "../context/AuthProvider";

import './Admin.css';

function Admin_product() {
    
    const [product, setProduct] = useState([]);

    const [productList, setProductList] = useState([]);
    const [hddList, setHddList] = useState([]);
    const [colorList, setColorList] = useState([]);
    const [plusList, setPlusList] = useState([]);

    const [prodSeq, setProdSeq] = useState("");

    // const [getAll] = useState([]);

    // //paging
    // const [page, setPage] = useState(1);
	// const [totalCnt, setTotalCnt] = useState(0);

    // // Link 용 (함수) 
    const navigate = useNavigate();

    /* product 전체 조회 */
	const getAllProduct = async () => {

		await axios.get("http://localhost:3000/admin/product/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[Admin_product.js] getAllProduct() success :D");
				
                console.log(resp.data);
                setProductList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[Admin_product.js] getAllProduct() error :<");
				console.log(err);
			});
	}
    
    /* hdd 전체 조회 */
	const getAllHdd = async () => {

		await axios.get("http://localhost:3000/admin/hdd/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[Admin_product.js] getAllHdd() success :D");
				
                console.log(resp.data);
                setHddList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[Admin_product.js] getAllHdd() error :<");
				console.log(err);
			});
	}

    /* color 전체 조회 */
	const getAllColor = async () => {

		await axios.get("http://localhost:3000/admin/color/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[Admin_product.js] getAllColor() success :D");
				
                console.log(resp.data);
                setColorList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[Admin_product.js] getAllColor() error :<");
				console.log(err);
			});
	}

    /* plus 전체 조회 */
	const getAllPlus = async () => {

		await axios.get("http://localhost:3000/admin/plus/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[Admin_product.js] getAllPlus() success :D");
				
                console.log(resp.data);
                setPlusList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[Admin_product.js] getAllPlus() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
        getAllProduct();
		getAllHdd();
		getAllColor();
		getAllPlus();
	}, []);

    const updateProduct = {
        prodSeq: product.prodSeq,
        prodName: product.prodName,
        prodPrice: product.prodPrice,
        prodCnt: product.prodCnt,
        hddSeq: product.hddSeq,
        colorSeq: product.colorSeq
    }

    const moveupdateProduct = (event) => {
        navigate(`/admin/product/update/:${prodSeq}`, {state: {data: product}});
    }

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">상품 관리</h1>                    
                    </div>

                    <div className="d-flex justify-content-between">
                        <div className="col-4">
                            <div>
                                <h1 className="admin_product_subtitle">Hdd</h1>
                            </div>
                            <div>
                                <table className="product_table">
                                    <thead>
                                        <th className="product_th">번호</th>
                                        <th className="product_th">용량</th>
                                        <th className="product_th">금액번호</th>
                                    </thead>
                                    <tbody>
                                        {
                                            hddList.map (function(hdd, idx) {
                                                return(
                                                    <TableRow_hdd obj={hdd} key={idx} cnt={idx+1} />
                                                )
                                            })
                                        }
                                        {/* <td className="product_td">
                                            <Link to="/admin/hdd/update">번호</Link>
                                        </td>
                                        <td className="product_td">용량</td>
                                        <td className="product_td">금액번호</td> */}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div className="col-4">
                            <div>
                                <h1 className="admin_product_subtitle">Color</h1>
                            </div>
                            <div>
                                <table className="product_table">
                                    <thead>
                                        <th className="product_th">번호</th>
                                        <th className="product_th">색상</th>
                                    </thead>
                                    <tbody>
                                        {
                                            colorList.map (function(color, idx) {
                                                return(
                                                    <TableRow_color obj={color} key={idx} cnt={idx+1} />
                                                )
                                            })
                                        }
                                        {/* <td className="product_td">
                                            <Link to="/admin/color/update">번호</Link>
                                        </td>
                                        <td className="product_td">색상</td> */}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div className="col-4">
                            <div>
                                <h1 className="admin_product_subtitle">Plus</h1>
                            </div>
                            <div>
                                <table className="product_table">
                                    <thead>
                                        <th className="product_th">번호</th>
                                        <th className="product_th">추가금액</th>
                                    </thead>
                                    <tbody>
                                        {
                                            plusList.map (function(plus, idx) {
                                                return(
                                                    <TableRow_plus obj={plus} key={idx} cnt={idx+1} />
                                                )
                                            })
                                        }
                                        {/* <td className="product_td">
                                            <Link to="/admin/hdd/update">번호</Link>
                                        </td>
                                        <td className="product_td">추가금액</td> */}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div>
                        <div>
                            <h1 className="admin_product_subtitle">Product</h1>
                        </div>
                        <div>
                            <table className="product_table">
                                <thead>
                                    <th className="product_th col-2">모델명</th>
                                    <th className="product_th col-2">상품이름</th>
                                    <th className="product_th col-2">가격</th>
                                    <th className="product_th col-2">용량</th>
                                    <th className="product_th col-2">색상</th>
                                    <th className="product_th col-2">재고</th>
                                </thead>
                                <tbody>
                                    {
                                        productList.map (function(product, idx) {
                                            return(
                                                <TableRow_prod obj={product} key={idx} cnt={idx+1} />
                                            )
                                        })
                                    }
                                    {/* <td className="product_td">
                                        <Link to="/admin/product/update">내용</Link>
                                    </td>
                                    <td className="product_td">내용</td>
                                    <td className="product_td">내용</td>
                                    <td className="product_td">내용</td>
                                    <td className="product_td">내용</td>
                                    <td className="product_td">내용</td> */}
                                </tbody>
                            </table>

                            {/* <Pagination className="pagination"
                                activePage={page}
                                itemsCountPerPage={10}
                                totalItemsCount={totalCnt}
                                pageRangeDisplayed={5}
                                prevPageText={"‹"}
                                nextPageText={"›"}
                            onChange={changePage} /> */}
                        </div>
                    </div>

                    <div className="d-flex justify-content-center">
					    <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                        <Button size={"default"} color={"blue"} text={"등록하기"}
                            onClick={() => {navigate('/admin/product/create')}}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

function TableRow_hdd(props) {

    const hdd = props.obj;

    return (
        <tr>
            {
            <>
                <td className="product_td">
                    <Link to={{ pathname: `/admin/hdd/getOne/${hdd.hddSeq}`}}>
                        <span className="">{hdd.hddSeq}</span>
                    </Link>
                </td>
                <td className="product_td">{hdd.capacity}</td>
                <td className="product_td">{hdd.plusSeq}</td>
            </>
            }
        </tr>
    )
}

function TableRow_color(props) {

    const color = props.obj;

    return (
        <tr>
            {
            <>
                <td className="product_td">
                    <Link to={{ pathname: `/admin/color/getOne/${color.colorSeq}`}}>
                        <span className="">{color.colorSeq}</span>
                    </Link>
                </td>
                <td className="product_td">{color.color}</td>
            </>
            }
        </tr>
    )
}

function TableRow_plus(props) {

    const plus = props.obj;

    return (
        <tr>
            {
            <>
                <td className="product_td">
                    <Link to={{ pathname: `/admin/plus/getOne/${plus.plusSeq}`}}>
                        <span className="">{plus.plusSeq}</span>
                    </Link>
                </td>
                <td className="product_td">{plus.price}</td>
            </>
            }
        </tr>
    )
}

function TableRow_prod(props) {

    const product = props.obj;

    return (
        <tr>
            {
            <>
                <td className="product_td">
                    <Link to={{ pathname: `/admin/product/getOne/${product.prodSeq}` }}>
                        <span className="">{product.prodSeq}</span>
                    </Link>
                </td>
                <td className="product_td">{product.prodName}</td>
                <td className="product_td">{product.prodPrice}</td>
                <td className="product_td">{product.prodCnt}</td>
                <td className="product_td">{product.hddSeq}</td>
                <td className="product_td">{product.colorSeq}</td>
            </>
            }
        </tr>
    )
}

export default Admin_product;