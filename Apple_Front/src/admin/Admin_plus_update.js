import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

import Button from '../common/Button';


function Admin_plus_update() {
   
    const { headers, setHeaders } = useContext(HttpHeadersContext);
	const { auth, setAuth } = useContext(AuthContext);
    const navigate = useNavigate();

    const location = useLocation();
	const { plus } = location.state;

    const [plusSeq, setPlusSeq] = useState(plus.plusSeq);
    const [price, setPrice] = useState(plus.price);

    const changePlusSeq = (event) => {setPlusSeq(event.target.value);};
    const changePrice = (event) => {setPrice(event.target.value);};

    /* hdd 수정 */
    const updatePlus = async () => {

        const req = {
            plusSeq: plusSeq,
            price: price,
        }

        await axios
            .patch(`http://localhost:3000/admin/plus/update/${plus.plusSeq}`, req)
            .then((resp) => {
                console.log("[Admin_plus_updqte.js] updatePlus() success :D");
                console.log(resp.data);

                if (resp.data.updatePlus == 1) {
                    alert("상품을 성공적으로 수정했습니다 :D");
                    navigate(`/admin/plus/getOne/${plus.plusSeq}`); // 글 상세로 이동
                }
            })
            .catch((err) => {
                console.log("[Admin_plus_updqte.js] updatePlus() error :<");
                console.log(err);
            });
    };

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">추가금 옵션 수정</h1>                    
                    </div>
                    <div className="admin_product part1">
                        <div>
                            <h2 className="admin_product_subtitle">Plus</h2>
                        </div>
                        <div>
                            <table className="create_table">
                                <tbody>
                                    <tr className="create_tr">
                                        <th className="create_th">추가금 코드</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={plusSeq} onChange={changePlusSeq}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">추가 금액</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={price} onChange={changePrice}></input>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                        <Button size={"default"} color={"blue"} text={"수정하기"}
                            onClick={updatePlus}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_plus_update;