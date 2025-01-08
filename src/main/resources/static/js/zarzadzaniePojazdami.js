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
                row.setAttribute('data-id', tramwaj.id); // Dodaj atrybut data-id
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

// Funkcja do edytowania tramwaju w tabeli
function editTramwaj(id) {
    const row = document.querySelector(`tr[data-id="${id}"]`);
    const cells = row.querySelectorAll('td');

    // Przekształć komórki na inputy
    cells[1].innerHTML = `<input type="text" value="${cells[1].innerText}">`; // Model
    cells[2].innerHTML = `<input type="text" value="${cells[2].innerText}">`; // Numer boczny
    cells[3].innerHTML = `<input type="number" value="${cells[3].innerText}">`; // Rok produkcji
    cells[4].innerHTML = `<input type="number" value="${cells[4].innerText}">`; // Pojemność
    cells[5].innerHTML = `<input type="text" value="${cells[5].innerText}">`; // Uwagi (opcjonalne)

    // Zmień przycisk 'Edytuj' na 'Zapisz'
    cells[6].innerHTML = `<button onclick="saveTramwaj(${id})">Zapisz</button>
                          <button onclick="cancelEdit(${id})">Anuluj</button>`;
}

// Funkcja do zapisania edytowanego tramwaju
function saveTramwaj(id) {
    const row = document.querySelector(`tr[data-id="${id}"]`);
    const cells = row.querySelectorAll('td');

    // Pobierz nowe wartości z inputów
    const model = cells[1].querySelector('input').value;
    const numerBoczny = cells[2].querySelector('input').value;
    const rokProdukcji = parseInt(cells[3].querySelector('input').value);
    const pojemnosc = parseInt(cells[4].querySelector('input').value);
    const uwagi = cells[5].querySelector('input').value;

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

// Funkcja do anulowania edycji
function cancelEdit(id) {
    loadTramwaje(); // Przywróć oryginalne dane tramwaju
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
