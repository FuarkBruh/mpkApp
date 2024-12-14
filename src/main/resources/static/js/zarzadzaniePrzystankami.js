// Funkcja do załadowania przystanków
function loadPrzystanki() {
    fetch('/api/przystanki')
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('table tbody');
            tbody.innerHTML = ''; // Wyczyść tabelę

            data.forEach(przystanek => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${przystanek.id}</td>
                    <td>${przystanek.nazwa}</td>
                    <td>${przystanek.lokalizacja}</td>
                    <td>${przystanek.uwagi || ''}</td>
                    <td>
                        <button onclick="editPrzystanek(${przystanek.id})">Edytuj</button>
                        <button onclick="deletePrzystanek(${przystanek.id})">Usuń</button>
                    </td>
                `;
                tbody.appendChild(row);
            });
        })
        .catch(error => console.error('Błąd podczas ładowania przystanków:', error));
}

// Funkcja do usuwania przystanku
function deletePrzystanek(id) {
    if (confirm('Czy na pewno chcesz usunąć ten przystanek?')) {
        fetch(`/api/przystanki/${id}`, {
            method: 'DELETE'
        })
            .then(() => loadPrzystanki()) // Odśwież tabelę po usunięciu
            .catch(error => console.error('Błąd podczas usuwania przystanku:', error));
    }
}

// Funkcja do edytowania przystanku
function editPrzystanek(id) {
    const nazwa = prompt('Podaj nową nazwę przystanku:');
    const lokalizacja = prompt('Podaj nową lokalizację:');
    const uwagi = prompt('Podaj nowe uwagi:');

    if (nazwa && lokalizacja) {
        const przystanek = { nazwa, lokalizacja, uwagi };

        fetch(`/api/przystanki/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(przystanek)
        })
            .then(() => loadPrzystanki()) // Odśwież tabelę po edycji
            .catch(error => console.error('Błąd podczas edytowania przystanku:', error));
    } else {
        alert('Wszystkie pola (poza uwagami) muszą być wypełnione.');
    }
}

// Obsługa formularza dodawania nowego przystanku
document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('form[action="/przystanki/dodaj"]').addEventListener('submit', function (event) {
        event.preventDefault(); // Zapobiega przeładowaniu strony

        const formData = new FormData(this);
        const przystanek = Object.fromEntries(formData.entries());

        fetch('/api/przystanki', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(przystanek)
        })
            .then(() => {
                this.reset(); // Wyczyszczenie formularza
                loadPrzystanki(); // Odśwież tabelę
            })
            .catch(error => console.error('Błąd podczas dodawania przystanku:', error));
    });

    // Załaduj przystanki po otwarciu strony
    loadPrzystanki();
});
