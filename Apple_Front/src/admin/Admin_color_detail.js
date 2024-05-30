import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";

import Button from '../common/Button';


function Admin_color_detail() {

    const { auth, setAuth } = useContext(AuthContext)
    const [color, setColor] = useState({});
    const {colorSeq} = useParams();

    const navigate = useNavigate();

    /* color 1개 불러오기 */
    const findByIdColor = async () => {

		await axios.get(`http://localhost:3000/admin/color/getOne/${colorSeq}`)
		.then((resp) => {
			console.log("[Admin_color_detail.js] findByIdColor() success :D");
			console.log(resp.data);
            setColor(resp.data);

		})
		.catch((err) => {
			console.log("[Admin_color_detail.js] findByIdColor() error :<");
			console.log(err);
		});
	}

    useEffect(() => {
		findByIdColor();
	}, []);

    const updateColor = {
		colorSeq: color.colorSeq,
        color: color.color
	}

    const moveUpdate = (event) => {
        navigate(`/admin/color/update/${colorSeq}`, {
            state : {data : color}
        });
    }

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">색상 옵션 정보 자세히 보기</h1>                    
                    </div>
                    <div className="admin_product part1">
                        <div>
                            <h2 className="admin_product_subtitle">Color</h2>
                        </div>
                        <div>
                            <table className="create_table">
                                <tbody>
                                    <tr className="create_tr">
                                        <th className="create_th">색상 코드</th>
                                        <td className="create_td">
                                            <span>{color.colorSeq}</span>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">색상</th>
                                        <td className="create_td">
                                            <span>{color.color}</span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                        <Link to="/admin/color/update/${colorSeq}"
                            state={{ color: updateColor}} >
                            <Button size={"default"} color={"blue"} text={"수정하기"} ></Button>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_color_detail;