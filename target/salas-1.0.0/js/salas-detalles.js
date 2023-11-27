var slideIndex = 1;

function cambiarSlide(n) {
    mostrarSlide(slideIndex += n);
}

function mostrarSlide(n) {
    var i;
    var slides = document.getElementsByClassName("item");
    if (n > slides.length) { slideIndex = 1; }
    if (n < 1) { slideIndex = slides.length; }
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slides[slideIndex - 1].style.display = "block";
}

// Asegúrate de iniciar el carrusel al cargar la página
window.onload = function () {
    mostrarSlide(slideIndex);
};