// Funkcja do załadowania przystanków i wyświetlenia ich na mapie
// Funkcja do załadowania przystanków i wyświetlenia ich na mapie
function zaladujPrzystanki() {
    fetch('/api/przystanki')
        .then(odpowiedz => odpowiedz.json())
        .then(dane => {
            const tabelaCialo = document.querySelector('table tbody');
            tabelaCialo.innerHTML = ''; // Wyczyść tabelę

            dane.forEach(przystanek => {
                // Zainicjalizuj wiersz
                const wiersz = document.createElement('tr');

                // Dodaj dane do odpowiednich komórek
                wiersz.innerHTML = `
                    <td>${przystanek.id}</td>
                    <td>${przystanek.nazwa}</td>
                    <td>${przystanek.lokalizacja}</td>
                    <td>${przystanek.dataDodania}</td>
                    <td>${przystanek.dataEdycji || ''}</td>
                    <td>${przystanek.uwagi || ''}</td>
                    <td>
                        <button onclick="edytujPrzystanek(${przystanek.id})">Edytuj</button>
                        <button onclick="usunPrzystanek(${przystanek.id})">Usuń</button>
                    </td>
                `;

                tabelaCialo.appendChild(wiersz);
            });
        })
        .catch(blad => console.error('Błąd podczas ładowania przystanków:', blad));
}



// Funkcja do zaznaczania lokalizacji na mapie
function ustawKlikniecieMapy(mapa) {
    let znacznik; // Zmienna do przechowywania znacznika

    mapa.on('click', function (zdarzenie) {
        const szerokosc = zdarzenie.latlng.lat;
        const dlugosc = zdarzenie.latlng.lng;

        // Sprawdzenie, czy znacznik już istnieje, jeśli tak, to go usuwamy
        if (znacznik) {
            mapa.removeLayer(znacznik);
        }

        // Dodanie nowego znacznika w miejscu kliknięcia
        znacznik = L.marker([szerokosc, dlugosc]).addTo(mapa);

        // Ustawienie wartości lokalizacji w formularzu
        document.getElementById('lokalizacja').value = `${szerokosc}, ${dlugosc}`;
    });
}

// Funkcja do inicjalizacji mapy
function inicjalizujMape() {
    const mapa = L.map('map').setView([51.737623656033456, 19.48979792360597], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(mapa);

    // Umożliwia zaznaczanie lokalizacji na mapie
    ustawKlikniecieMapy(mapa);
}

// Funkcja do usuwania przystanku
function usunPrzystanek(id) {
    if (confirm('Czy na pewno chcesz usunąć ten przystanek?')) {
        fetch(`/api/przystanki/${id}`, {
            method: 'DELETE'
        })
            .then(() => zaladujPrzystanki()) // Odśwież tabelę po usunięciu
            .catch(blad => console.error('Błąd podczas usuwania przystanku:', blad));
    }
}

// Funkcja do edytowania przystanku
function edytujPrzystanek(id) {
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
            .then(() => {
                zaladujPrzystanki(); // Odśwież tabelę po edycji
            })
            .catch(blad => console.error('Błąd podczas edytowania przystanku:', blad));
    } else {
        alert('Wszystkie pola (poza uwagami) muszą być wypełnione.');
    }
}


// Obsługa formularza dodawania nowego przystanku
document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('form[action="/przystanki/dodaj"]').addEventListener('submit', function (zdarzenie) {
        zdarzenie.preventDefault(); // Zapobiega przeładowaniu strony

        const daneFormularza = new FormData(this);
        const przystanek = Object.fromEntries(daneFormularza.entries());

        fetch('/api/przystanki', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(przystanek)
        })
            .then(() => {
                this.reset(); // Wyczyszczenie formularza
                zaladujPrzystanki(); // Odśwież tabelę
            })
            .catch(blad => console.error('Błąd podczas dodawania przystanku:', blad));
    });

    // Załaduj przystanki po otwarciu strony
    inicjalizujMape();
    zaladujPrzystanki();
});

