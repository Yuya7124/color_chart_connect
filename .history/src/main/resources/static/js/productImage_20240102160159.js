function outputName() {
    var file_form = document.getElementById("file");

    file_form.addEventListener("change", (e) => {
      if (window.File) {
        // 指定したファイルの情報を取得
        var input_file = file_form.files[0];

        var imgUrl = window.URL.createObjectURL(file_form);
        file_form.src = imgUrl;
         
        console.log(input_file.name);
      }
    });
}

window.addEventListener('load', outputName);