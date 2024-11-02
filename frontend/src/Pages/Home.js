import React, { useState ,useEffect} from "react";
import axios  from "axios";
export default function Home() {
    const [users, setUsers] = useState([]);
    useEffect(() => {
        getUsers();
    },[]); // [] = runs only once 
    const getUsers = async () => {
        const response = await axios.get("http://localhost:8080/users");
        setUsers(response.data);
        console.log(response.data);
      };
  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">First</th>
              <th scope="col">Username</th>
              <th scope="col">Handle</th>
            </tr>
          </thead>
          <tbody>
            { // for mapping user array in table every new user will appear here with id index + 1
                users.map((user, index) => (
                    <tr>
                        <th scope="row" key={index} >{index+1}</th>
                        <td>{user.name}</td>
                        <td>{user.userName}</td>
                        <td>{user.email}</td>
                    </tr>
                ))
            }
          </tbody>
        </table>
      </div>
    </div>
  );
}
