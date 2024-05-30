import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect} from "react";

import Button from '../common/Button';
import './Admin.css';

function Admin_member() {

    const [memberList, setMemberList] = useState([]);
    const [memId, setMemId] = useState("");
    
    const navigate = useNavigate();

    /* 회원 전체 조회 */
	const getAll = async () => {

		await axios.get("http://localhost:3000/user/getAll")
			.then((resp) => {											// 회원가입 성공 시 출력
				console.log("[TestFindAll.js] getAll() success :D");
				
                console.log(resp.data);
                setMemberList(resp.data);

			}).catch((err) => {											// 회원가입 실패 시 출력
				console.log("[TestFindAll.js] getAll() error :<");
				console.log(err);
			});
	}

    useEffect(() => {
		getAll();
	}, []);

    return (
        <div>
            <div className="container">
                <div className="admin_container">
                    <div>
                        <h1 className="admin_title">회원 관리</h1>                    
                    </div>
                    <div>
                        <table className="member_table">
                            <thead>
                                <th className="member_th">회원번호</th>
                                <th className="member_th">회원 ID</th>
                                <th className="member_th">회원 PW</th>
                            </thead>
                            <tbody>
                                { 
                                    memberList.map( function(member, idx) {
                                        return(
                                            <TableRow obj={member} key={idx} cnt={idx + 1} />
                                        )
                                    })
                                }
                            </tbody>
                        </table>
                    </div>
                    <div className="d-flex justify-content-center">
                        <Button size={"default"} color={"none"} text={"뒤로가기"}
                            onClick={() => {navigate(-1)}}></Button>
                    </div>
                </div>
            </div>
        </div>
    );
}

function TableRow(props) {
    
	const member = props.obj;

	return (
			<tr>
					{
						<>
							<td className="member_td">
								{member.memSeq}
							</td>

                            <td className="member_td">
                                <Link to={{ pathname: `/admin/member/${member.memId}` }}>
                                    <span className="underline bbs-title" >{member.memId}</span>
                                </Link>
                            </td>
                            <td className="member_td">{member.memPw}</td>
						</>
					}			
			</tr>
	);
}

export default Admin_member;