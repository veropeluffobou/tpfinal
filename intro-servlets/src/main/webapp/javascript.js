document.addEventListener("DOMContentLoaded", function() { 

function totalAPagar(cantTickets,categoria){
    const valorTicket = 200;
    let total = cantTickets * valorTicket;

    switch (categoria){
        case "Estudiante":
            total = total - (total * 0.8)
            break;
        case "Trainee":
            total = total - (total * 0.5)
            break;
        case "Junior":
            total = total - (total * 0.15)
            break;
    }
    return total
}

let boton = document.getElementById("btnResumen")

let formulario = document.getElementById("formTickets")

formulario.addEventListener("submit", (e)=>{
    e.preventDefault();
}
)

boton.addEventListener( "click", ()=>{
    let cantidad = document.getElementById("inputCantidad").value
    let categoria = document.getElementById("inputCategoria").value

    let valor = totalAPagar(cantidad,categoria)

    let divMje = document.getElementById ("divResultado")

    divMje.style.display = "block"

    divMje.textContent = "Total a pagar: $" + valor

}
)

let boton2 = document.getElementById("btnBorrar")

boton2.addEventListener( "click", ()=>{
    let divMje = document.getElementById ("divResultado")

    divMje.style.display = "none"

}
)

});
