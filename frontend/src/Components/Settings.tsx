import { useState } from 'react';
import profile_pic1 from '../Misc/8-bit-dog-nobg.png';
import 'bootstrap/dist/css/bootstrap.min.css';

function Settings() {
  const [items, setItems] = useState(['Pet 1', 'Pet 2', 'Pet 3']);

  const removeItem = (index: number) => {
    setItems(items.filter((_, i) => i !== index));
  };

  const resetItem = (index: number) => {
    setItems(items.map((item, i) => (i === index ? `Item ${index + 1}` : item)));
  };

  return (
    <div className='d-flex justify-content-center pt-4 pb-2'>
      <div className="card align-items-center text-bg-light" style={{ width: "500px" }}>
        <img src={profile_pic1} className="card-img-top py-3" alt="profile picture" style={{ width: "100%", height: "auto" }} />
        <h2 className="card-title text-center"><kbd className='bg-success text-white'>PROFILE</kbd></h2>
        <div className="card-body" style={{ width: "100%" }}>
          <div className="input-group mb-4" style={{ height: "60px" }}>
            <div className="input-group-prepend">
              <div className="input-group-text" style={{ fontSize: "1.5rem", height: "60px", display: 'flex', alignItems: 'center' }}>@</div>
            </div>
            <input type="text" className="form-control text-black" placeholder="Pedro" disabled style={{ fontSize: "1.5rem", height: "60px" }}></input>
          </div>
          <div className='d-flex justify-content-center pt-2'>
            <button type="button" className="btn btn-outline-danger btn-block w-100" style={{ fontSize: "1.5rem", height: "60px" }} >Logout</button>
          </div>
          <div className='pt-4' style={{ width: "100%" }}>
            <ul className="list-group" style={{ fontSize: "1.2rem" }}>
              {items.map((item, index) => (
                <li key={index} className="list-group-item d-flex justify-content-between align-items-center py-3">
                  {item}
                  <div>
                    <button className="btn btn-warning btn-sm mx-1" style={{ fontSize: "1.2rem", padding: "0.5rem 1rem" }} onClick={() => resetItem(index)}>Reset</button>
                    <button className="btn btn-danger btn-sm mx-1" style={{ fontSize: "1.2rem", padding: "0.5rem 1rem" }} onClick={() => removeItem(index)}>Remove</button>
                  </div>
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Settings;