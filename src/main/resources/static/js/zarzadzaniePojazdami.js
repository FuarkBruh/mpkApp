document.addEventListener("DOMContentLoaded", function() {
    const responseDiv = document.getElementById('response');

    // Obsługa kliknięcia przycisku edycji
    document.querySelectorAll('form[action*="/update/"]').forEach(form => {
        form.addEventListener('submit', function(e) {
            // Usunięto e.preventDefault() – formularz działa normalnie
            const id = this.getAttribute('action').split('/').pop();
            console.log(`Przekierowanie do edycji pojazdu o ID: ${id}`);
        });
    });

    // Obsługa kliknięcia przycisku usunięcia
    document.querySelectorAll('form[action*="/delete/"]').forEach(form => {
        form.addEventListener('submit', function(e) {
            e.preventDefault(); // Blokuj domyślne zachowanie (potwierdzenie jest wymagane)
            const id = this.getAttribute('action').split('/').pop();
            if (confirm(`Czy na pewno chcesz usunąć tramwaj o ID: ${id}?`)) {
                this.submit(); // Wyślij formularz po potwierdzeniu
            }
        });
    });
});