function editLinia(id) {
    fetch(`/api/linie/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('id').value = data.id;
            document.getElementById('numerLinii').value = data.numerLinii;
            document.getElementById('calkowityCzasPrzejazdu').value = data.calkowityCzasPrzejazdu;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}