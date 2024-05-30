import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

import Button from '../common/Button';


function Admin_hdd_update() {
   
    const { headers, setHeaders } = useContext(HttpHeadersContext);
	const { auth, setAuth } = useContext(AuthContext);
    const navigate = useNavigate();

    const location = useLocation();
	const { hdd } = location.state;

    const [hddSeq, setHddSeq] = useState(hdd.hddSeq);
    const [capacity, setCapacity] = useState(hdd.capacity);
    const [plusSeq, setPlusSeq] = useState(hdd.plusSeq);

    const changeHddSeq = (event) => {setHddSeq(event.target.value);};
    const changeCapacity = (event) => {setCapacity(event.target.value);};
    const changePlusSeq = (event) => {setPlusSeq(event.target.value);};


    /* hdd 수정 */
    const updateHdd = async () => {

        const req = {
            hddSeq: hddSeq,
            capacity: capacity,
            plusSeq: plusSeq,
        }

        await axios
            .patch(`http://localhost:3000/admin/hdd/update/${hdd.hddSeq}`, req)
            .then((resp) => {
                console.log("[Admin_hdd_updqte.js] updateHdd() success :D");
                console.log(resp.data);

                if (resp.data.updateHdd == 1) {
                    alert("상품을 성공적으로 수정했습니다 :D");
                    navigate(`/admin/hdd/getOne/${hdd.hddSeq}`); // 글 상세로 이동
                }
            })
            .catch((err) => {
                console.log("[Admin_hdd_updqte.js] updateHdd() error :<");
                console.log(err);
            });
    };

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">용량 옵션 수정</h1>                    
                    </div>
                    <div className="admin_product part1">
                        <div>
                            <h2 className="admin_product_subtitle">Hdd</h2>
                        </div>
                        <div>
                            <table className="create_table">
                                <tbody>
                                    <tr className="create_tr">
                                        <th className="create_th">용량 코드</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={hddSeq} onChange={changeHddSeq}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">용량</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={capacity} onChange={changeCapacity}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">추가금 코드</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={plusSeq} onChange={changePlusSeq}></input>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}></Button>
                        <Button size={"default"} color={"blue"} text={"수정하기"}
                            onClick={updateHdd}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_hdd_update;