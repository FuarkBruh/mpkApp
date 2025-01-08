// TODO: Edycja lokalizacji przystanku poprzez mapę (jak będzie czas i chęć)

// Funkcja do załadowania przystanków i wyświetlenia ich na mapie
function zaladujPrzystanki() {
    fetch('/api/przystanki')
        .then(odpowiedz => odpowiedz.json())
        .then(dane => {
            const tabelaCialo = document.querySelector('table tbody');
            tabelaCialo.innerHTML = ''; // Wyczyść tabelę

            dane.forEach(przystanek => {
                const wiersz = document.createElement('tr');
                wiersz.setAttribute('data-id', przystanek.id); // Dodaj atrybut data-id
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

// Funkcja do edytowania przystanku
function edytujPrzystanek(id) {
    const wiersz = document.querySelector(`tr[data-id="${id}"]`);
    const komorki = wiersz.querySelectorAll('td');

    // Przekształć komórki na inputy
    komorki[1].innerHTML = `<input type="text" value="${komorki[1].innerText}">`; // Nazwa
    komorki[2].innerHTML = `<input type="text" value="${komorki[2].innerText}">`; // Lokalizacja
    komorki[5].innerHTML = `<input type="text" value="${komorki[5].innerText}">`; // Uwagi (opcjonalne)

    // Zmień przycisk 'Edytuj' na 'Zapisz'
    komorki[6].innerHTML = `<button onclick="zapiszPrzystanek(${id})">Zapisz</button>
                            <button onclick="anulujEdycje(${id})">Anuluj</button>`;
}

// Funkcja do zapisania edytowanego przystanku
function zapiszPrzystanek(id) {
    const wiersz = document.querySelector(`tr[data-id="${id}"]`);
    const komorki = wiersz.querySelectorAll('td');

    // Pobierz nowe wartości z inputów
    const nazwa = komorki[1].querySelector('input').value;
    const lokalizacja = komorki[2].querySelector('input').value;
    const uwagi = komorki[5].querySelector('input').value;

    if (nazwa && lokalizacja) {
        const przystanek = { nazwa, lokalizacja, uwagi };

        fetch(`/api/przystanki/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(przystanek)
        })
            .then(() => zaladujPrzystanki()) // Odśwież tabelę po edycji
            .catch(blad => console.error('Błąd podczas edytowania przystanku:', blad));
    } else {
        alert('Wszystkie pola (poza uwagami) muszą być wypełnione.');
    }
}

// Funkcja do anulowania edycji
function anulujEdycje(id) {
    zaladujPrzystanki(); // Przywróć oryginalne dane przystanku
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

// Funkcja do zaznaczania lokalizacji na mapie
function ustawKlikniecieMapy(mapa) {
    let znacznik;

    mapa.on('click', function (zdarzenie) {
        const szerokosc = zdarzenie.latlng.lat;
        const dlugosc = zdarzenie.latlng.lng;

        if (znacznik) {
            mapa.removeLayer(znacznik);
        }

        znacznik = L.marker([szerokosc, dlugosc]).addTo(mapa);
        document.getElementById('lokalizacja').value = `${szerokosc}, ${dlugosc}`;
    });
}

// Funkcja do inicjalizacji mapy
function inicjalizujMape() {
    const mapa = L.map('map').setView([51.737623656033456, 19.48979792360597], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(mapa);

    ustawKlikniecieMapy(mapa);
}

// Obsługa formularza dodawania nowego przystanku
document.addEventListener('DOMContentLoaded', () => {
    document.querySelector('form[action="/przystanki/dodaj"]').addEventListener('submit', function (zdarzenie) {
        zdarzenie.preventDefault();

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
                this.reset();
                zaladujPrzystanki();
            })
            .catch(blad => console.error('Błąd podczas dodawania przystanku:', blad));
    });

    inicjalizujMape();
    zaladujPrzystanki();
});
