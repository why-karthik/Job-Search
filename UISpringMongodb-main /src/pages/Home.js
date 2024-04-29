// import React from "react";
// import { Typography, Button } from "@mui/material";
// import { Link } from "react-router-dom";
// import "../App.css"

// const Home = () => {
//   return (
//     <div>
//       <Typography sx={{ margin:"5%" }} variant="h3" align="center">
//         Get Hired or Hire people for free!
//       </Typography>
//       <div>
//         <ul className="ul">
//           <li>
//           <Button sx={{ margin:"2% 3%"}} variant="outlined">
//             <Link to="/employer/dashboard">
//               Hire talent
//             </Link>
//             </Button>
//           </li>
//           <li>
//           <Button sx={{ margin:"2% 3%"}} variant="outlined">
//             <Link to="/employee/feed">
//               Get Job Now
//             </Link>
//             </Button>
//           </li>
//         </ul>
//       </div>
//     </div>
//   );
// };

// export default Home;

import React from "react";
import { Typography, Button, Box } from "@mui/material";
import { Link } from "react-router-dom";
import "../App.css";

const Home = () => {
  return (
    <div className="home-container">
      <Box className="button-container">
        <Button
          variant="outlined"
          component={Link}
          to="/employer/dashboard"
          className="select-button"
        >
          Hire Talent
        </Button>
        <Button
          variant="outlined"
          component={Link}
          to="/employee/feed"
          className="select-button"
        >
          Get Job Now
        </Button>
      </Box>
    </div>
  );
};

export default Home;




