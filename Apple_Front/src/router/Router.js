import { Routes, Route } from "react-router-dom";

import Home from "../common/Home"

import Cart from "../cart/Cart"

import Admin_product from "../admin/Admin_product"
import Admin_product_detail from "../admin/Admin_product_detail"
import Admin_product_create from "../admin/Admin_product_create"
import Admin_product_update from "../admin/Admin_product_update"

import Admin_hdd_detail from "../admin/Admin_hdd_detail"
import Admin_hdd_update from "../admin/Admin_hdd_update"

import Admin_color_detail from "../admin/Admin_color_detail"
import Admin_color_update from "../admin/Admin_color_update"

import Admin_plus_detail from "../admin/Admin_plus_detail"
import Admin_plus_update from "../admin/Admin_plus_update"

import Admin_payment from "../admin/Admin_payment"
import Admin_payment_detail from "../admin/Admin_payment_detail"

import Admin_member from "../admin/Admin_member"
import Admin_member_detail from "../admin/Admin_member_detail"

import Store from "../store/Store"
import Store_Detail_1 from "../store/Store_Detail_1"
import Store_Detail_2 from "../store/Store_Detail_2"
import Store_Detail_3 from "../store/Store_Detail_3"

import Payment from "../payment/Payment"
import Payment_backup from "../payment/Payment_backup"
import Payment_success from "../payment/Payment_success"

import Mypage from "../member/Mypage"
import Mypage_update from "../member/Mypage_update"
import Mypage_payment from "../member/Mypage_payment"
import Mypage_payment_detail from "../member/Mypage_payment_detail"

import Join from "../member/Join"
import Login from "../member/Login"
import Logout from "../member/Logout"

import Product from "../product/Product"
import Product_Detail_1 from "../product/Product_Detail_1"
import Product_Detail_2 from "../product/Product_Detail_2"
import Product_Detail_3 from "../product/Product_Detail_3"



function Router() {

	return (
			<Routes>
				<Route path="/" element={<Home />}></Route>

				<Route path="/cart" element={<Cart />}></Route>

				<Route path="/admin/product" element={<Admin_product />}></Route>
				<Route path="/admin/product/create" element={<Admin_product_create />}></Route>
				<Route path="/admin/product/getOne/:prodSeq" element={<Admin_product_detail />}></Route>
				<Route path="/admin/product/update/:prodSeq" element={<Admin_product_update />}></Route>

				<Route path="/admin/hdd/getOne/:hddSeq" element={<Admin_hdd_detail />}></Route>
				<Route path="/admin/hdd/update/:hddSeq" element={<Admin_hdd_update />}></Route>

				<Route path="/admin/color/getOne/:colorSeq" element={<Admin_color_detail />}></Route>
				<Route path="/admin/color/update/:colorSeq" element={<Admin_color_update />}></Route>

				<Route path="/admin/plus/getOne/:plusSeq" element={<Admin_plus_detail />}></Route>
				<Route path="/admin/plus/update/:plusSeq" element={<Admin_plus_update />}></Route>

				<Route path="/admin/payment" element={<Admin_payment />}></Route>
				<Route path="/payment/:paySeq" element={<Admin_payment_detail />}></Route>
				<Route path="/admin/member" element={<Admin_member />}></Route>
				<Route path="/admin/member/:memId" element={<Admin_member_detail />}></Route>

				<Route path="/store/" element={<Store />}></Route>
				<Route path="/store_detail/1" element={<Store_Detail_1 />}></Route>
				<Route path="/store_detail/2" element={<Store_Detail_2 />}></Route>
				<Route path="/store_detail/3" element={<Store_Detail_3 />}></Route>

				<Route path="/payment/" element={<Payment />}></Route>
				<Route path="/payment_success" element={<Payment_success />}></Route>

				<Route path="/mypage/:memId" element={<Mypage />}></Route>
				<Route path="/mypage/update/2" element={<Mypage_update />}></Route>
				<Route path="/mypage/payment" element={<Mypage_payment />}></Route>
				<Route path="/mypage/payment/:paySeq" element={<Mypage_payment_detail />}></Route>

				<Route path="/product" element={<Product />}></Route>
				<Route path="/product_detail/1" element={<Product_Detail_1 />}></Route>
				<Route path="/product_detail/2" element={<Product_Detail_2 />}></Route>
				<Route path="/product_detail/3" element={<Product_Detail_3 />}></Route>

				<Route path="/join" element={<Join />}></Route>
				<Route path="/login" element={<Login />}></Route>
				<Route path="/logout" element={<Logout />}></Route>
			</Routes>
	);
}

export default Router;