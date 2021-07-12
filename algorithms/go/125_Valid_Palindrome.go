func isPalindrome(s string) bool {
    processed := []rune{}
    for _, r := range s {
        if (48<=r && r<=57) || (65<=r && r<=90){ 
            processed = append(processed, r)
        }
        if 97<=r && r <= 122 {
            processed = append(processed, r-32)
        }
    }
    
    for i,j := 0, len(processed) -1; i < j; i,j = i+1,j-1 {
        if processed[i] != processed[j] {
            return false
        }  
    }
    
    return true
}