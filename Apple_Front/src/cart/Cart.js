import axios from "axios";
import { Link, useLocation, useParams, useNavigate } from "react-router-dom";
import { useContext, useEffect, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";
import './Cart.css';
import Button from '../common/Button';

import iphone15 from '../img/iphone_iphone15.png';


function Cart() {
	
	const { auth, setAuth } = useContext(AuthContext);
    const [cartProduct, setCartProduct] = useState({});
    const { cartpSeq } = useParams();
	
	const [product, setProduct] = useState({});
	const [prodPrice, setProdPrice] = useState(product.prodSeq);
    const {prodSeq} = useParams();
	
	const today = new Date();
	const formattedDate = `${today.getFullYear()}년 ${today.getMonth() + 1}월 ${today.getDate()+2}일`;
	
	const price = 1250000;
	const formattedPrice = price.toString().replace(/[^0-9]/gi, '')
		.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

	const navigate = useNavigate();

	/* 장바구니 1개 조회 */
    const getOneCartProduct = async () => {
        await axios
            .get(`http://localhost:3000/cart/getOneCartProduct/${1}`)
            .then((resp) => {
                console.log("[Cart.js] findByIdCartProduct() success :D");
                console.log(resp.data);
                setCartProduct(resp.data);
            })
            .catch((err) => {
                console.log("[Cart.js] findByIdCartProduct() error :<");
                console.log(err);
            });
    };

	/* product 1개 불러오기 */
    const findByIdProduct = async () => {

		await axios.get(`http://localhost:3000/admin/product/getOne/${1}`)
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
        getOneCartProduct();
		findByIdProduct();
    }, []);

    return (
		<div>
			<div className="container">
				<div className="cart_part1">
					<div>
						<h1 className="cart_part1_title">장바구니 총액: ￦{formattedPrice}</h1>
						<p className="cart_part1_subtitle">모든 주문에 무료 배송 서비스가 제공됩니다.</p>
						<Button size={"large"} color={"blue"} text={"결제"}
							onClick={() => {navigate('/payment')}}></Button>
						<p />

						{/* <Link to="/TestCartFindAll"><li>카트 실험</li></Link>
						<Link to="/TestCartProductFindAll"><li>카트 상품 실험</li></Link> */}

					</div>
				</div>
				<hr />
				<div className="cart_part2">
					<div className="cart_part2_left">
						<img src={iphone15} alt="" />
					</div>
					<div className="cart_part2_right">
						<div className="d-flex justify-content-between">
							<h1 className="cart_part2_title">iPhone15 256GB 블루</h1>
							<h1 className="cart_part2_subtitle">1개</h1>
						</div>
						<hr />
						<div>
							<p className="cart_part2_1">위 제품의 예상 수령 일자를 확인해보세요.</p>
							<p className="cart_part2_2">{formattedDate}</p>
						</div>
						<div className="cart_part2_right_3">
							<Button size={"default"} color={"red"} text={"삭제"}></Button>
						</div>
					</div>
				</div>

			</div>
		</div>
	);
    
    }
    
    export default Cart;