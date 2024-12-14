// tramwaje.js

// Funkcja do załadowania tramwajów
function loadTramwaje() {
    fetch('/api/tramwaje')
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('table tbody');
            tbody.innerHTML = ''; // Wyczyść tabelę

            data.forEach(tramwaj => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${tramwaj.id}</td>
                    <td>${tramwaj.model}</td>
                    <td>${tramwaj.numerBoczny}</td>
                    <td>${tramwaj.rokProdukcji}</td>
                    <td>${tramwaj.pojemnosc}</td>
                    <td>${tramwaj.uwagi || ''}</td>
                    <td>
                        <button onclick="editTramwaj(${tramwaj.id})">Edytuj</button>
                        <button onclick="deleteTramwaj(${tramwaj.id})">Usuń</button>
                    </td>
                `;
                tbody.appendChild(row);
            });
        })
        .catch(error => console.error('Błąd podczas ładowania tramwajów:', error));
}

// Funkcja do usuwania tramwaju
function deleteTramwaj(id) {
    if (confirm('Czy na pewno chcesz usunąć ten tramwaj?')) {
        fetch(`/api/tramwaje/${id}`, {
            method: 'DELETE'
        })
            .then(() => loadTramwaje()) // Odśwież tabelę po usunięciu
            .catch(error => console.error('Błąd podczas usuwania tramwaju:', error));
    }
}

// Funkcja do edytowania tramwaju
function editTramwaj(id) {
    const model = prompt('Podaj nowy model:');
    const numerBoczny = prompt('Podaj nowy numer boczny:');
    const rokProdukcji = parseInt(prompt('Podaj nowy rok produkcji:'));
    const pojemnosc = parseInt(prompt('Podaj nową pojemność:'));
    const uwagi = prompt('Podaj nowe uwagi:');

    if (model && numerBoczny && rokProdukcji && pojemnosc) {
        const tramwaj = { model, numerBoczny, rokProdukcji, pojemnosc, uwagi };

        fetch(`/api/tramwaje/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(tramwaj)
        })
            .then(() => loadTramwaje()) // Odśwież tabelę po edycji
            .catch(error => console.error('Błąd podczas edytowania tramwaju:', error));
    } else {
        alert('Wszystkie pola (poza uwagami) muszą być wypełnione.');
    }
}

// Obsługa formularza dodawania nowego tramwaju
document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('form[action="/tramwaje/dodaj"]').addEventListener('submit', function (event) {
        event.preventDefault(); // Zapobiega przeładowaniu strony

        const formData = new FormData(this);
        const tramwaj = Object.fromEntries(formData.entries());

        // Konwertuj wartości liczbowe
        tramwaj.rokProdukcji = parseInt(tramwaj.rokProdukcji);
        tramwaj.pojemnosc = parseInt(tramwaj.pojemnosc);

        fetch('/api/tramwaje', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(tramwaj)
        })
            .then(() => {
                this.reset(); // Wyczyszczenie formularza
                loadTramwaje(); // Odśwież tabelę
            })
            .catch(error => console.error('Błąd podczas dodawania tramwaju:', error));
    });

    // Załaduj tramwaje po otwarciu strony
    loadTramwaje();
});
