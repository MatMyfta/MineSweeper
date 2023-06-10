/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addContent(x,y,res) {
    var tbl = document.getElementById("ms-table");
    var row = tbl.rows[x];
    row.cells[y].innerHTML = res;
    
    if (res == "B") {
        row.cells[y].classList.add("bomb");
        restart();
    }
    else row.cells[y].classList.add("number");
}

function loadDoc(row, column) {
    var x, y;
    if (row == null && column == null) {        // selezionato dal form
        x = document.getElementById("row").value-1;
        y = document.getElementById("column").value-1;
    } else {                                    // selezionato dalla tabella
        x = row;
        y = column;
    }
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var res = this.responseText;
            document.getElementById("result").innerHTML = "Result is " + res;
            addContent(x,y,res);
        }
    };
    xhttp.open("GET", "../GetValue?x=" + x + "&y=" + y, true);
    xhttp.send();
}

function restart() {
    alert("Hai perso!\nPremi \"OK\" per ricominciare");
    window.location.replace("../Restart");
}