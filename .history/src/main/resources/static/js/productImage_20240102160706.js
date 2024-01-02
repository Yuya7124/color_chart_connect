function outputName() {
    var file_form = document.getElementById("file");

    file_form.addEventListener("change", (e) => {
      if (window.File) {
        // 指定したファイルの情報を取得
        var input_file = file_form.files[0];

        var fileReader = new FileReader();
        fileReader.onload = function() {
          var dataUrl = this.result;
          var img = document.getElementById('file-preview')
          img.src = dataUrl;
        }
        console.log(input_file.name);
      }
    });
}

window.addEventListener('load', outputName);