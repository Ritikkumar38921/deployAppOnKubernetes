import logo from "./logo.svg";
import "./App.css";
import { useEffect, useState } from "react";
import axios from "axios";
import toast, { Toaster } from 'react-hot-toast'
import GetAllDetails from "./GetAllDetails";
import { myService } from "./AxiosInstance";

function App() {
  let [alert,setAlert] = useState(true);
  let [age, setAge] = useState("");
  let [name, setName] = useState("");
  let [rows,setRows] = useState([]);

  async function getResult(){
          
    let getResult = await myService.get('/store/getAll')
    console.log("getResult : " , getResult);
    let res = getResult.data; 
    console.log("rows : " , rows);
    setRows(res);
    setAlert(false);
  }
  

  useEffect(()=> {
    if(alert){
      getResult(); 
    }
  } , [alert]);

  const savePage = async () => {
    try {
      let res = await myService.post("/store/save", {
        age,
        name,
      });
      console.log("save successfully");
      toast.success("Save Successfully");
      setAlert(true);
      
    } catch (error) {
      console.log(error);
       toast.error("Failed");
    }
  };

  return (
    <>
      <div
        style={{
          backgroundColor: "rgb(187 185 187)",
          height: "41vh",
          color: "white",
          display: "flex",
          width : "60vw",
          margin : "auto",
          marginTop : "20px",
          flexDirection: "column",
          alignItems: "center",
          justifyContent: "center",
        }}
      >
        <div style={{ fontSize: "24px"  }}>
          <label>
            Your first name:
            <input
              name="firstName"
              value={name}
              style={{marginLeft : "20px"}}
              onChange={(e) => setName(e.target.value)}
            />
          </label>
        </div>
        <hr />
        <div style={{ fontSize: "24px" }}>
          <label>Your age:</label>
          <input
            name="age"
            value={age}
            style={{marginLeft : "20px"}}
            onChange={(e) => setAge(e.target.value)}
          />
        </div>
      </div>
      <button
        style={{
          color: "#fdfbff",
          backgroundColor: "#1677c6",
          padding: "10px 42px",
          float: "right",
          marginRight: "20%",
          marginTop : "20px",
          cursor:"pointer"
        }}
        onClick={savePage}
      >
        Submit
      </button>
      <Toaster
        position="bottom-right"
        toastOptions={{
          style: {
            backgroundColor: "rgb(187 185 187)",
            width : "200px",
            // color: "white",
          },
        }}
      />

      <GetAllDetails rows={rows}/>
    </>
  );
}

export default App;
