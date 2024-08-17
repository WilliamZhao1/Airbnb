// Assuming each step of your form is contained within elements with the class 'tab-pane'
// and that each 'tab-pane' has a unique ID like 'nav-item1', 'nav-item2', etc.

let currentStep = 1; // Start at the first step
const totalSteps = 5; // Adjust this to your total number of steps
let formData = new FormData(); // Object to store form data
const houseDetail = {}; //Object that is being submitted to the backend
const houseAmenity = new Set();
var housePictures = null;

function navigateSteps(direction) {
    // Calculate the next step based on the current step and direction
    var newStep = currentStep + direction;

    // Get the divs for the current and next steps
    var currentStepDiv = document.getElementById('nav-item' + currentStep);
    var currentStepTitle = document.getElementById('nav-item' + currentStep + '-tab');
    var newStepDiv = document.getElementById('nav-item' + newStep);
    var newStepTitle = document.getElementById('nav-item' + newStep + '-tab');

    // Save current step data
    saveStepData(currentStep);    

    // Check if we are within the bounds of the steps
    if (newStepDiv) {

        // Add 'active' and 'show' classes to the next step
        newStepDiv.classList.add('show', 'active');
        newStepTitle.classList.add('active');
        newStepTitle.setAttribute('aria-selected', 'true');

        // Remove 'active' and 'show' classes from the current step
        currentStepDiv.classList.remove('show', 'active');
        currentStepTitle.classList.remove('active');
        currentStepTitle.setAttribute('aria-selected', 'false');
        
        // Update the current step to the new step
        currentStep = newStep;
    }
}

// Set the step when switching tabs by clicking on the titles
function setStep(step) {
  saveStepData(step);
  currentStep = step;
}


// --------------------------- Step 2 ----------------------------
// Function to trigger file input click
function triggerFileUpload() {
  document.getElementById('pictureUpload').click();
}

// Add event listener to your custom button
document.getElementById('fileUploadTrigger').addEventListener('click', triggerFileUpload);
let pictureUploadElement = document.getElementById('pictureUpload');
let pictureUploadMessageElement = document.getElementById("pictureUploadMessage");
const imageMap = new Map();
let counter = 0;
pictureUploadElement.onchange = function() {
  for(let i = 0; i < this.files.length; i++) {
    let file = this.files[i];

    // Add image to imageMap
    imageMap.set(counter, file);

    // Create a URL for the uploaded file
    const fileUrl = URL.createObjectURL(file);

    // Create the alert div element
    const alertDiv = document.createElement('div');
    alertDiv.className = 'alert alart_style_one alert-dismissible fade show mb20';
    alertDiv.setAttribute('role', 'alert');

    // Create the link element for the file name
    const fileLink = document.createElement('a');
    fileLink.href = fileUrl;
    fileLink.target = '_blank'; // Open in a new tab
    fileLink.textContent = file.name; // Set the link text to the file name

    // Append the file link to the alert div
    alertDiv.appendChild(fileLink);

    // Create the close button for the alert
    const closeButton = document.createElement('i');
    closeButton.className = 'far fa-xmark btn-close';
    closeButton.setAttribute('data-bs-dismiss', 'alert');
    closeButton.setAttribute('aria-label', 'Close');
    closeButton.onclick = function() {
      imageMap.delete(counter);
    };

    // Append the close button to the alert div
    alertDiv.appendChild(closeButton);

    pictureUploadMessageElement.appendChild(alertDiv);
    counter++;
  }
}

// --------------------------- Step 2 End ---------------------------

function saveStepData(stepNumber) {
    // Get all input elements in the step
    let inputs = document.querySelectorAll('#nav-item' + stepNumber + ' input, #nav-item' + stepNumber + ' textarea, #nav-item' + stepNumber + ' select');
  
    // Loop through inputs and save their data
    inputs.forEach(function(input) {
      if (input.type == "checkbox") {
        if (input.checked) houseAmenity.add(input.name);
      } else if (input.type == "file") {
        housePictures = input.files;
      } else {
        houseDetail[input.name] = input.value;
      }
    });

    // Save the data for the current step
    sessionStorage.setItem('nav-item' + stepNumber + 'Data', JSON.stringify(formData));
  }
  

function submitForm() {
  formData = new FormData();
  let tempHouseAmenity = Array.from(houseAmenity);
  console.log(tempHouseAmenity);
  houseDetail["houseAmenity"] = tempHouseAmenity;
  formData.append('formData', JSON.stringify(houseDetail));

  // Append each file to 'pictures'
  for (let i = 0; i < housePictures.length; i++) {
    formData.append('pictures', housePictures[i]);
  }
  fetch('http://localhost:8080/uploadProperty', {
    method: 'POST',
    body: formData, 
  })
  .then(response => {
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.text(); 
  })
  .then(data => {
    console.log('Server response:', data); 
  })
  .catch(error => console.error('Error:', error));
}

