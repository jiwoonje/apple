import { Link, useParams, useNavigate, useLocation } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

import Button from '../common/Button';


function Admin_color_update() {
   
    const { headers, setHeaders } = useContext(HttpHeadersContext);
	const { auth, setAuth } = useContext(AuthContext);
    const navigate = useNavigate();

    const location = useLocation();
	const { color } = location.state;

    const [colorSeq1, setColorSeq1] = useState(color.colorSeq);
    const [color1, setColor1] = useState(color.color);

    const changeColorSeq = (event) => {setColorSeq1(event.target.value);};
    const changeColor = (event) => {setColor1(event.target.value);};

    /* color 수정 */
    const updateColor = async () => {

        const req = {
            colorSeq1: color.colorSeq1,
            color1: color.color1,
        }

        await axios
            .patch(`http://localhost:3000/admin/color/update/${color.colorSeq}`, req)
            .then((resp) => {
                console.log("[Admin_color_updqte.js] updateColor() success :D");
                console.log(resp.data);

                if (resp.data.updateColor == 1) {
                    alert("상품을 성공적으로 수정했습니다 :D");
                    navigate(`/admin/color/getOne/${color.colorSeq}`); // 글 상세로 이동
                }
            })
            .catch((err) => {
                console.log("[Admin_color_updqte.js] updateColor() error :<");
                console.log(err);
            });
    };

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">색상 옵션 수정</h1>                    
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
                                            <input type="text" className="create_form"
                                                value={colorSeq1} onChange={changeColorSeq}></input>
                                        </td>
                                    </tr>
                                    <tr className="create_tr">
                                        <th className="create_th">색상</th>
                                        <td className="create_td">
                                            <input type="text" className="create_form"
                                                value={color1} onChange={changeColor}></input>
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
                            onClick={updateColor}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Admin_color_update;