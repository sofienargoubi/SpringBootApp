const app = require("./src/app");
require("./src/config/database").connect();



app.listen(3000, () => {
    console.log("running on port 3000");
    console.log("--------------------------");
  });