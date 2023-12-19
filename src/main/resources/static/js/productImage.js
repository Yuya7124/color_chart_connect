function outputName() {
    var fileform = document.getElementById("file");

    fileform.addEventListener("change", (e) => {
      if (window.File) {
        // 指定したファイルの情報を取得
        var inputfile = fileform.files[0];
        var fileName = inputfile.name;
        console.log(inputfile.name);
      }
    });
}

window.addEventListener('load', outputName);