function outputName() {
    var file_form = document.getElementById("file");

    file_form.addEventListener("change", (e) => {
      if (window.File) {
        // 指定したファイルの情報を取得
        var input_file = file_form.files[0];

        var img_url = window.URL.
        var fileName = input_file.name;
        console.log(input_file.name);
      }
    });
}

window.addEventListener('load', outputName);