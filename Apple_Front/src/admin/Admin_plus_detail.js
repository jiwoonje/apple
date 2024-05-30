import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";

import Button from '../common/Button';


function Admin_plus_detail() {

    const { auth, setAuth } = useContext(AuthContext)
    const [plus, setPlus] = useState({});
    const {plusSeq} = useParams();

    const navigate = useNavigate();

    /* plus 1개 불러오기 */
    const findByIdPlus = async () => {

		await axios.get(`http://localhost:3000/admin/plus/getOne/${plusSeq}`)
		.then((resp) => {
			console.log("[Admin_plus_detail.js] findByIdPlus() success :D");
			console.log(resp.data);
            setPlus(resp.data);

		})
		.catch((err) => {
			console.log("[Admin_plus_detail.js] findByIdPlus() error :<");
			console.log(err);
		});
	}

    useEffect(() => {
		findByIdPlus();
	}, []);

    const updatePlus = {
		plusSeq: plus.plusSeq,
        price: plus.price,
	}

    const moveUpdate = (event) => {
        navigate(`/admin/plus/update/${plusSeq}`, {
            state : {data : plus}
        });
    }

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">추가금 옵션 정보 자세히 보기</h1>                    
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
                                            <span>{plus.plusSeq}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">추가 금액</th>
                                        <td className="create_td">
                                            <span>{plus.price}</span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                        <Link to="/admin/plus/update/${plusSeq}"
                            state={{ plus: updatePlus}} >
                            <Button size={"default"} color={"blue"} text={"수정하기"} ></Button>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_plus_detail;