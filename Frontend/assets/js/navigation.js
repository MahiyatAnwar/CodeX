// Handle navigation for authenticated vs non-authenticated users
document.addEventListener('DOMContentLoaded', function() {
    // Check if user is logged in (this will be replaced with actual auth check later)
    const isLoggedIn = false; // Temporary - will be set by backend
    
    const topicsLink = document.getElementById('topics-link');
    const problemsLink = document.getElementById('problems-link');
    const dashboardLink = document.getElementById('dashboard-link');
    
    // Set href based on authentication
    if (isLoggedIn) {
        topicsLink.href = 'topics.html';
        problemsLink.href = 'problems.html';
        dashboardLink.href = 'dashboard.html';
    } else {
        // Redirect to login if not authenticated
        topicsLink.href = 'login.html';
        problemsLink.href = 'login.html';
        dashboardLink.href = 'login.html';
        
        // Add click handlers to show message
        [topicsLink, problemsLink, dashboardLink].forEach(link => {
            link.addEventListener('click', function(e) {
                if (!isLoggedIn) {
                    e.preventDefault();
                    alert('Please sign in to access this page');
                    window.location.href = 'login.html';
                }
            });
        });
    }
});

function setupLearningPlanNavigation() {
    const topicItems = document.querySelectorAll('.topic-item');

    topicItems.forEach(item => {
        item.addEventListener('click', function() {
            const isLoggedIn = false; // Temporary - will be set by backend

            if (!isLoggedIn) {
                alert('Please sign in to access learning materials');
                window.location.href = 'login.html';
            } else {
                // Get topic name from data attribute or text
                const topicName = this.querySelector('h5').textContent.toLowerCase();
                window.location.href = `topics.html?topic=${topicName}`;
            }
        });
    });
}

// Force hover styles for auth buttons
document.addEventListener('DOMContentLoaded', function() {
    const loginBtn = document.querySelector('a[href="login.html"]');
    const registerBtn = document.querySelector('a[href="register.html"]');
    
    if (loginBtn) {
        loginBtn.classList.add('btn-outline-primary', 'auth-btn');
    }
    
    if (registerBtn) {
        registerBtn.classList.add('btn-primary', 'auth-btn');
    }
});

