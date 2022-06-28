//fetch
const start = async () => {
  let lecturas = [];
  const getLecturas = async () => {
    const response = await fetch("/temperaturas");
    const temperaturas = await response.json();

    console.log(temperaturas);
    return temperaturas;
  };

   
  lecturas = await getLecturas();

  //document query selector
  

  document.querySelector(".btn-getLecturas").addEventListener("click", async (e) => {
    e.preventDefault();
    console.log("lecturas");
    const lecturasNormalizadas = lecturas.map(({ fecha, grados}) => ({
      fecha,
      grados,
    }));
    console.log(lecturasNormalizadas);
    document.querySelector(".lecturas").innerText = JSON.stringify(lecturasNormalizadas)
  });
};

start();
