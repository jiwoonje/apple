import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";

import Button from '../common/Button';


function Admin_hdd_detail() {

    const { auth, setAuth } = useContext(AuthContext)
    const [hdd, setHdd] = useState({});
    const {hddSeq} = useParams();

    const navigate = useNavigate();

    /* hdd 1개 불러오기 */
    const findByIdHdd = async () => {

		await axios.get(`http://localhost:3000/admin/hdd/getOne/${hddSeq}`)
		.then((resp) => {
			console.log("[Admin_hdd_detail.js] findByIdHdd() success :D");
			console.log(resp.data);
            setHdd(resp.data);

		})
		.catch((err) => {
			console.log("[Admin_hdd_detail.js] findByIdHdd() error :<");
			console.log(err);
		});
	}

    useEffect(() => {
		findByIdHdd();
	}, []);

    const updateHdd = {
		hddSeq: hdd.hddSeq,
        capacity: hdd.capacity,
        plusSeq: hdd.plusSeq
	}

    const moveUpdate = (event) => {
        navigate(`/admin/hdd/update/${hddSeq}`, {
            state : {data : hdd}
        });
    }

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">용량 옵션 정보 자세히 보기</h1>                    
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
                                            <span>{hdd.hddSeq}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">용량</th>
                                        <td className="create_td">
                                            <span>{hdd.capacity}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">추가금 코드</th>
                                        <td className="create_td">
                                            <span>{hdd.plusSeq}</span>
                                        </td>
                                    </tr>
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}></Button>
                        <Link to="/admin/hdd/update/${hddSeq}"
                            state={{ hdd: updateHdd}} >
                            <Button size={"default"} color={"blue"} text={"수정하기"} ></Button>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_hdd_detail;