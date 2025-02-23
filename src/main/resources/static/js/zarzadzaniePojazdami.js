document.addEventListener("DOMContentLoaded", function() {
    const responseDiv = document.getElementById('response');

    // Przykład dodatkowej funkcjonalności w JavaScript
    // Obsługa kliknięcia przycisku edycji (opcjonalnie)
    document.querySelectorAll('form[action*="/update/"]').forEach(form => {
        form.addEventListener('submit', function(e) {
            e.preventDefault();
            const id = this.getAttribute('action').split('/').pop();
            // Możesz dodać logikę edycji tutaj
            alert(`Edytuj tramwaj o ID: ${id}`);
        });
    });

    // Obsługa kliknięcia przycisku usunięcia (opcjonalnie)
    document.querySelectorAll('form[action*="/delete/"]').forEach(form => {
        form.addEventListener('submit', function(e) {
            e.preventDefault();
            const id = this.getAttribute('action').split('/').pop();
            if (confirm(`Czy na pewno chcesz usunąć tramwaj o ID: ${id}?`)) {
                this.submit();
            }
        });
    });
});